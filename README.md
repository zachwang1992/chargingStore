# chargingStore
ChargingStore is an application which represents a store for car charging session entities. It will hold all records in memory and provide
REST API.

Each entity of the store represents unique charging session that can be in progress or finished. Entity can have the following fields:
```java
UUID id;
String stationId;
LocalDateTime startedAt;
LocalDateTime stoppedAt;
StatusEnum status;
```

## Endpoints to implement
* POST /chargingSessions  
Submit a new charging session for the station  
request body:  
 ```java
  {
    "stationId": "ABC-12345"
  }
 ```
response body:  
 ```java
  {
    "id": "d9bb7458-d5d9-4de7-87f7-7f39edd51d18",
    "stationId": "ABC-12345",
    "startedAt": "2019-05-06T19:00:20.529",
    "status": "IN_PROGRESS"
  }
 ```
* PUT /chargingSessions/{id}  
Stop charging session
response body:  
 ```java
  {
    "id": "d9bb7458-d5d9-4de7-87f7-7f39edd51d18",
    "stationId": "ABC-12345",
    "startedAt": "2019-05-06T21:15:01.198",
    "stoppedAt": "2019-05-06T21:17:01.198",
    "status": "FINISHED"
  }
 ```
* GET /chargingSessions  
Retrieve all charging sessions  
response body:  
 ```java
  [{
    "id": "d9bb7458-d5d9-4de7-87f7-7f39edd51d18",
    "stationId": "ABC-12345",
    "startedAt": "2019-05-06T19:00:20.529",
    "stoppedAt": "2019-05-06T21:17:01.198",
    "status": "IN_PROGRESS"
   },
   {
    "id": "69acaf1b-743f-47df-9339-abe50998b201",
    "stationId": "ABC-12346",
    "startedAt": "2019-05-06T19:01:35.245",
    "stoppedAt": "2019-05-06T21:17:01.198",
    "status": "FINISHED"
   }]
 ```
* GET /chargingSessions/summary  
Retrieve a summary of submitted charging sessions including:  
totalCount – total number of charging session updates for the last minute  
startedCount – total number of started charging sessions for the last minute  
stoppedCount – total number of stopped charging sessions for the last minute  
response body:  
 ```java
  {
    "totalCount": 5,
    "startedCount": 1,
    "stoppedCount": 4
  }
 ```
## Technology Stack
Java 8, Maven, JAX-RS, Jersey, Tomcat
## Running the application
### To run application:
```java
mvn tomcat:run
```
### To start application in a browser:  
http://localhost:8080/chargingstore/webapi/chargingSessions  
### To test application:
```java
mvn exec:java -Dexec.mainClass=org.everon.evbox.chargingstore.test.Test
```

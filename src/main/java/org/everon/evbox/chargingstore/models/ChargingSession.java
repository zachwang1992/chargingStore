package org.everon.evbox.chargingstore.models;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents a charging session.
 * @author Wang Long
 *
 */
@XmlRootElement
public class ChargingSession {

	private UUID id;
	private String stationId;
	private LocalDateTime startedAt;
	private LocalDateTime stoppedAt;
	private StatusEnum status;
	
	/**
	 * This constructs a charging session without any field
	 */
	public ChargingSession() {
		
	}
	
	/**
	 * This constructs a charging session with a specified id, stationId, startedAt, stoppedAt and status
	 * @param id the UUID of the charging session
	 * @param stationId the charging station id of the charging session
	 * @param startedAt the starting time of the charging session
	 * @param stoppedAt the stopping time of the charging session
	 * @param status the status of the charging session
	 */
	public ChargingSession(UUID id, String stationId, LocalDateTime startedAt, LocalDateTime stoppedAt,
			StatusEnum status) {
		this.id = id;
		this.stationId = stationId;
		this.startedAt = startedAt;
		this.stoppedAt = stoppedAt;
		this.status = status;
	}

	/**
	 * Method to get the id of the charging session.
	 * @return the id of the charging session
	 */
	public UUID getId() {
		return id;
	}
	
	/**
	 * Method to set the id of the charging session.
	 * @param id the id of the charging session
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	
	/**
	 * Method to get the charging station id of the charging session.
	 * @return the charging station id of the charging session
	 */
	public String getStationId() {
		return stationId;
	}
	
	/**
	 * Method to set the charging station id of the charging session.
	 * @param stationId the charging station id of the charging session
	 */
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	
	/**
	 * Method to get the starting time of the charging session.
	 * @return the starting time of the charging session
	 */
	public LocalDateTime getStartedAt() {
		return startedAt;
	}
	
	/**
	 * Method to set the starting time of the charging session.
	 * @param startedAt the starting time of the charging session
	 */
	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
	}
	
	/**
	 * Method to get the stopping time of the charging session.
	 * @return the stopping time of the charging session
	 */
	public LocalDateTime getStoppedAt() {
		return stoppedAt;
	}
	
	/**
	 * Method to set the stopping time of the charging session.
	 * @param stoppedAt the stopping time of the charging session
	 */
	public void setStoppedAt(LocalDateTime stoppedAt) {
		this.stoppedAt = stoppedAt;
	}
	
	/**
	 * Method to get the status of the charging session.
	 * @return the status of the charging session
	 */
	public StatusEnum getStatus() {
		return status;
	}
	
	/**
	 * Method to set the status of the charging session.
	 * @param status the status of the charging session
	 */
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
	
}

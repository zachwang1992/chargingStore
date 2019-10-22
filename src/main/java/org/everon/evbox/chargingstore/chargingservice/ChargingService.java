package org.everon.evbox.chargingstore.chargingservice;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.everon.evbox.chargingstore.database.DatabaseClass;
import org.everon.evbox.chargingstore.models.ChargingSession;
import org.everon.evbox.chargingstore.models.ChargingSummary;
import org.everon.evbox.chargingstore.models.StatusEnum;

/**
 * The class represents charging service of charging sessions.
 * The charging sessions can be modified using different methods.
 * @author Wang Long
 *
 */
public class ChargingService {

	private Map<UUID, ChargingSession> chargingSessions = DatabaseClass.getChargingSessions();
	private static final Duration MINUTE = Duration.ofMinutes(1L);
	
	/**
	 * This constructs a charging service without any field.
	 */
	public ChargingService() {
		
	}
	
	/**
	 * Method to get all charging sessions in this charging service.
	 * @return all charging sessions in an ArrayList
	 */
	public List<ChargingSession> getAllChargingSessions(){
		return new ArrayList<ChargingSession>(chargingSessions.values());
	}
	
	/**
	 * Method to add a charging session in charging service
	 * @param chargingSession the charging session that will be added 
	 * @return the added charging session
	 */
	public ChargingSession addChargingSession(ChargingSession chargingSession) {
		chargingSession.setId(UUID.randomUUID());
		chargingSession.setStartedAt(LocalDateTime.now());
		chargingSession.setStatus(StatusEnum.IN_PROGRESS);
		chargingSessions.put(chargingSession.getId(), chargingSession);
		return chargingSession;
	}
	
	/**
	 * Method to update charging session in charging service
	 * @param chargingSession the charging session that will be updated
	 * @return the updated charging session
	 */
	public ChargingSession updateChargingSession(ChargingSession chargingSession) {
		chargingSession.setStoppedAt(LocalDateTime.now());
		chargingSession.setStatus(StatusEnum.FINISHED);
		chargingSessions.put(chargingSession.getId(), chargingSession);
		return chargingSession;
	}
	
	/**
	 * Method to get the summary of charging sessions for the last minute.
	 * @return the summary of charging sessions for the last minute
	 */
	public ChargingSummary summarizeChargingSessions() {
		LocalDateTime oneMinBefore = LocalDateTime.now().minus(MINUTE);
		long startedCount = startedCounter(oneMinBefore);
		long stoppedCount = stoppedCounter(oneMinBefore);
		return new ChargingSummary(startedCount + stoppedCount, startedCount, stoppedCount);
	}
	
	/**
	 * Method to get total number of started charging sessions from certain starting time
	 * @param time the starting time to count the total number of started charging sessions
	 * @return total number of started charging sessions
	 */
	private long startedCounter(LocalDateTime time) {
		return chargingSessions.values().stream()
				.filter(x -> (x.getStartedAt().isAfter(time))).count();
	}
	
	/**
	 * Method to get total number of stopped charging sessions from certain starting time
	 * @param time the starting time to count the total number of stopped charging sessions
	 * @return total number of stopped charging sessions
	 */
	private long stoppedCounter(LocalDateTime time) {
		return chargingSessions.values().stream()
				.filter(x -> (x.getStatus() == StatusEnum.FINISHED && x.getStoppedAt().isAfter(time))).count();
	}
	
}

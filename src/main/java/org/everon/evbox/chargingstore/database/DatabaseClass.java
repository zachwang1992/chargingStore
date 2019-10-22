package org.everon.evbox.chargingstore.database;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.everon.evbox.chargingstore.models.ChargingSession;

/**
 * This class represents the database of all charging sessions. 
 * The charging sessions and their ids are stored in a Map. 
 * @author Wang Long
 *
 */
public class DatabaseClass {

	private static Map<UUID, ChargingSession> chargingSessions = new ConcurrentHashMap<>();
	
	/**
	 * Method to get charging sessions in database.
	 * @return charging sessions in a Map
	 */
	public static Map<UUID, ChargingSession> getChargingSessions(){
		return chargingSessions;
	}
}

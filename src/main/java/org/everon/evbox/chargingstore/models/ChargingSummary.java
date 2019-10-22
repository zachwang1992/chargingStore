package org.everon.evbox.chargingstore.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents a summary of charging sessions for the last minute.
 * @author Wang Long
 *
 */
@XmlRootElement
public class ChargingSummary {

	private long totalCount;
	private long startedCount;
	private long stoppedCount;
	
	/**
	 * This constructs a summary of charging session without any field.
	 */
	public ChargingSummary() {
		
	}

	/**
	 * This constructs a summary of charging session with a specified totalCount,
	 * startedCount and stoppedCount.
	 * @param totalCount total number of charging session updates for the last minute
	 * @param startedCount total number of started charging sessions for the last minute
	 * @param stoppedCount total number of stopped charging sessions for the last minute
	 */
	public ChargingSummary(long totalCount, long startedCount, long stoppedCount) {
		this.totalCount = totalCount;
		this.startedCount = startedCount;
		this.stoppedCount = stoppedCount;
	}

	/**
	 * Method to get total number of charging session updates for the last minute.
	 * @return total number of charging session updates for the last minute
	 */
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * Method to set total number of charging session updates for the last minute.
	 * @param totalCount total number of charging session updates for the last minute
	 */
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * Method to get total number of started charging sessions for the last minute.
	 * @return total number of started charging sessions for the last minute
	 */
	public long getStartedCount() {
		return startedCount;
	}

	/**
	 * Method to set total number of started charging sessions for the last minute.
	 * @param startedCount total number of started charging sessions for the last minute
	 */
	public void setStartedCount(long startedCount) {
		this.startedCount = startedCount;
	}

	/**
	 * Method to get total number of stopped charging sessions for the last minute.
	 * @return total number of stopped charging sessions for the last minute
	 */
	public long getStoppedCount() {
		return stoppedCount;
	}

	/**
	 * Method to set total number of stopped charging sessions for the last minute.
	 * @param stoppedCount total number of stopped charging sessions for the last minute
	 */
	public void setStoppedCount(long stoppedCount) {
		this.stoppedCount = stoppedCount;
	}
	
}

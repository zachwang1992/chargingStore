package org.everon.evbox.chargingstore.exceptions;

/**
 * The class represents DataNotFound Exception.
 * The exception is thrown when the required charging session is not found.
 * @author Wang Long
 *
 */
public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 565059574888142080L;

	/**
	 * This constructs a DataNotFound Exception with an error message
	 * @param message the error message
	 */
	public DataNotFoundException(String message) {
		super(message);
	}
}

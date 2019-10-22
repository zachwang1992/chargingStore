package org.everon.evbox.chargingstore.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represent a response to an error.
 * @author Wang Long
 *
 */
@XmlRootElement
public class ErrorResponse {

	private String errorMessage;
	private int errorCode;
	
	/**
	 * This constructs an error response without any field.
	 */
	public ErrorResponse() {
		
	}

	/**
	 * This constructs an error response with a specified errorMessage and errorCode.
	 * @param errorMessage the error message in an error response
	 * @param errorCode the error code in an error response
	 */
	public ErrorResponse(String errorMessage, int errorCode) {
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	/**
	 * Method to get the error message in an error response.
	 * @return the error message in an error response
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Method to set the error message in an error response.
	 * @param errorMessage error message in an error response
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Method to get the error code in an error response.
	 * @return the error code in an error response
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Method to set the error code in an error response.
	 * @param errorCode the error code in an error response
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
}

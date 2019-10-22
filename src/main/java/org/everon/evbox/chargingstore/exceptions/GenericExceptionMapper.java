package org.everon.evbox.chargingstore.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.everon.evbox.chargingstore.models.ErrorResponse;

/**
 * The class handles generic exceptions.
 * @author Wang Long
 *
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	/**
	 * Response to a generic exception
	 */
	@Override
	public Response toResponse(Throwable exception) {
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), 500);
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorResponse)
				.build();
	}
}
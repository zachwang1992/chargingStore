package org.everon.evbox.chargingstore.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.everon.evbox.chargingstore.models.ErrorResponse;

/**
 * The class handles DataNotFoundException.
 * @author Wang Long
 *
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	/**
	 * Response to a DataNotFoundException
	 */
	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), 404);
		return Response.status(Status.NOT_FOUND)
				.entity(errorResponse)
				.build();
	}
}

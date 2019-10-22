package org.everon.evbox.chargingstore.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.everon.evbox.chargingstore.chargingservice.ChargingService;
import org.everon.evbox.chargingstore.exceptions.DataNotFoundException;
import org.everon.evbox.chargingstore.models.ChargingSession;
import org.everon.evbox.chargingstore.models.ChargingSummary;
import org.everon.evbox.chargingstore.models.StatusEnum;

/**
 * Root resource (exposed at "chargingSessions" path)
 * @author Wang Long
 *
 */
@Path("/chargingSessions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ChargingResource {

	ChargingService chargingService = new ChargingService();
	
	/**
	 * Method handling HTTP GET request.
	 * @return all charging sessions in JSON format
	 */
	@GET
	public List<ChargingSession> getChargingSessions() {
		return chargingService.getAllChargingSessions();
	}
	
	/**
	 * Method handling HTTP POST request.
	 * @param chargingSession the charging session that will be created
	 * @return the created charging session in JSON format
	 */
	@POST
	public ChargingSession addChargingSession(ChargingSession chargingSession) {
		return chargingService.addChargingSession(chargingSession);
	}
	
	/**
	 * Method handling HTTP PUT request.
	 * @param id the id of the charging session that will be updated
	 * @return the updated charging session in JSON format
	 */
	@PUT
	@Path("/{id}")
	public ChargingSession updateChargingSession(@PathParam("id") String id) {
		ChargingSession chargingSession = chargingService.getAllChargingSessions().stream()
				.filter(s -> (id.equals(s.getId().toString()) && s.getStatus() == StatusEnum.IN_PROGRESS)).findAny()
				.orElseThrow(() -> new DataNotFoundException("No in-progress charging session with id: " + id +" is found."));
		return chargingService.updateChargingSession(chargingSession);
	}
	
	/**
	 * Method handling HTTP GET request with path "summary".
	 * @return the summary of charging sessions for the last minute in JSON format
	 */
	@GET
	@Path("/summary")
	public ChargingSummary summarizeChargingSessions() {
		return chargingService.summarizeChargingSessions();
	}
	
}

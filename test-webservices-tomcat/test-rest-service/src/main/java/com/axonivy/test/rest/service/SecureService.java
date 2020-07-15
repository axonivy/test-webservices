package com.axonivy.test.rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


/**
 * Demonstrates a service which protects it's methods with <code>javax.security</code> annotations.
 */
@Singleton
@Path("admin")
public class SecureService {
	
	private List<String> entries = new ArrayList<>(Arrays.asList("Hello world"));

	/**
	 *  {@link PermitAll}: no authentication required to call this method. Anonymous access granted.
	 * @return response
	 */
	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)
	public Response showEntries()
	{
		return Response.status(Status.OK)
				.entity(entries)
				.build();
	}
	
	/**
	 * No <code>javax.security</code> annotation present: Defaults to HTTP-BASIC auth required.
	 * @param newEntry 
	 * @return response
	 */
	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	public Response addEntry(String newEntry)
	{
		entries.add(newEntry);
		return Response.status(Status.OK)
				.entity("Added entry '"+newEntry+"'")
				.build();
	}
	
	/** 
	 * {@link RolesAllowed}: only HTTP-BASIC authenticated users which own the role 'Manager' are allowed to call this method. 
	 * @param id 
	 * @param newEntry 
	 * @return response
	 */
	@POST @Path("/{entryId}")
	@RolesAllowed("Manager")
	public Response updateEntry(@PathParam("entryId") int id, String newEntry)
	{
		entries.set(id, newEntry);
		return Response.status(Status.OK)
				.entity("Update entry with id ("+id+") to '"+newEntry+"'")
				.build();
	}
	
	/**
	 * {@link DenyAll}: Access to this method is blocked for all users 
	 * @param id 
	 */
	@DELETE @Path("/{entryId}")
	@DenyAll
	public void removeEntry(@PathParam("entryId") int id)
	{
		entries.remove(id);
	}
	
}

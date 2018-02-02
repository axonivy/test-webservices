package com.axonivy.test.rest.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;

/**
 * Simple RESTful service. The REST interface is defined by the JAX-RS annotations on the methods and it's path.<br/>
 * 
 * @since 6.1.1
 */
@Singleton
@Path("persons")
public class PersonService {

	private List<Person> persons = new ArrayList<>();
	
	public PersonService()
	{
		addNewPerson("Bruno", "Bütler");
		addNewPerson("Reto", "Weiss");
		addNewPerson("Renato", "Stalder");
		addNewPerson("Reguel", "Wermelinger");
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersons(@QueryParam("name") String name)
	{
		if (StringUtils.isBlank(name))
		{
			return Response.status(Status.OK)
					.entity(persons)
					.build();
		}
		
		return Response.status(Status.OK)
				.entity(findPersons(name))
				.build();
	}

	private List<Person> findPersons(String name) {
		List<Person> matches = new ArrayList<>();
		for(Person candidate : persons)
		{
			if (candidate.getFirstname().contains(name) ||
				candidate.getLastname().contains(name))
			{
				matches.add(candidate);
			}
		}
		return matches;
	}
	
	@GET @Path("/{personId}")
	@Produces(MediaType.APPLICATION_JSON+"; qs=1") 
	// higher quality = default if not exactly specified or multiple types are accepted.
	public Response getPerson(@PathParam("personId") int personId)
	{
		try
		{
			Person person = persons.get(personId);
			return Response.status(Status.OK)
						.entity(person)
						.build();
		} 
		catch (IndexOutOfBoundsException ex)
		{
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@GET @Path("/{personId}")
	@Produces(MediaType.TEXT_PLAIN+"; qs=0.5")
	public Response getPersonPlain(@PathParam("personId") int personId)
	{
		try
		{
			Person person = persons.get(personId);
			return Response.status(Status.OK)
						.entity(person.toString())
						.build();
		} 
		catch (IndexOutOfBoundsException ex)
		{
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@PUT
	public Response add(@FormParam("firstname") String firstname, @FormParam("lastname") String lastname)
	{
		Person person = addNewPerson(firstname, lastname);
		Link createdLink = Link.fromPath("persons/{id}").rel("createdPerson").build(person.getId());
		return Response.status(Status.CREATED)
					.location(createdLink.getUri())
					.links(createdLink)
					.build();
	}
	
	public static class CreatedPersonMeta
	{
		public final int id;
		public final Calendar createdAt;
		
		private CreatedPersonMeta(int id)
		{
			this.id = id;
			this.createdAt = Calendar.getInstance();
		}
	}
	
	
	@DELETE @Path("/{personId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePerson(@PathParam("personId") int personId)
	{
		try
		{
			Person deleted = persons.remove(personId);
			return Response.status(Status.OK)
					.entity(deleted)
					.build();
		} 
		catch (IndexOutOfBoundsException ex)
		{
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@POST @Path("/{personId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("personId") int personId, Person person)
	{
		try
		{
			Person existing = persons.get(personId);
			persons.set(existing.getId(), person);
			return Response.status(Status.OK)
					.build();
		} 
		catch (IndexOutOfBoundsException ex)
		{
			return Response.status(Status.NOT_FOUND)
					.entity("user with id '"+personId+"' does not exist.")
					.build();
		}
	}
	
	
	
	private Person addNewPerson(String firstname, String lastname) 
	{
		Person person = new Person();
		person.setFirstname(firstname);
		person.setLastname(lastname);
		person.setId(persons.size());
		persons.add(person);
		return person;
	}
}

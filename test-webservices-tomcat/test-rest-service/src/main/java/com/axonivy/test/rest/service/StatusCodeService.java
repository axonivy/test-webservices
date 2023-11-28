package com.axonivy.test.rest.service;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Path("status")
public class StatusCodeService {

  @GET
  @Path("/{status}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Response get(@PathParam("status") int status) {
    return createResponse(status);
  }

  @HEAD
  @Path("/{status}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Response head(@PathParam("status") int status) {
    return createResponse(status);
  }

  private Response createResponse(int status) {
    return Response.status(status).build();
  }
}

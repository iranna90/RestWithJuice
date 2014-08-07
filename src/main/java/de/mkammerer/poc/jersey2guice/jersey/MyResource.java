package de.mkammerer.poc.jersey2guice.jersey;

import de.mkammerer.poc.jersey2guice.TimeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/")
public class MyResource {
    private final TimeService timeService;

    @Inject
    public MyResource(TimeService timeService) {
        this.timeService = timeService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return timeService.now().toString();
    }
}
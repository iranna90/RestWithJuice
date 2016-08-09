package de.mkammerer.poc.jersey2guice.jersey;

import de.mkammerer.poc.jersey2guice.TimeService;
import de.mkammerer.poc.jersey2guice.datatypes.ShortDate;

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
    @Produces("text/shortdate")
    public ShortDate getIt() {
        return timeService.now();

    }
}
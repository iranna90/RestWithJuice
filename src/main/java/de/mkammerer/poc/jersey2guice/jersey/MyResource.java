package de.mkammerer.poc.jersey2guice.jersey;

import de.mkammerer.poc.jersey2guice.TimeService;
import de.mkammerer.poc.jersey2guice.datatypes.ShortDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/")
public class MyResource {
    private final TimeService timeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MyResource.class);

    @Inject
    public MyResource(TimeService timeService) {
        this.timeService = timeService;
    }

    @GET
    @Produces("text/shortdate")
    public ShortDate getIt() {
        return timeService.now();

    }

    @Path("/{day}")
    @GET
    @Produces("text/shortdate")
    public ShortDate getDate(@PathParam("day") ShortDate shortDate) {
        LOGGER.info("Short date requested for {} ", shortDate);
        return shortDate;
    }
}
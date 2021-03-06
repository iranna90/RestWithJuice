package de.mkammerer.poc.jersey2guice.providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

/**
 * Created by iranna on 9-8-16.
 */
@Provider
@PreMatching
public class PreMatchFilter implements ContainerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreMatchFilter.class);

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        LOGGER.info("Prematch filter");
    }
}

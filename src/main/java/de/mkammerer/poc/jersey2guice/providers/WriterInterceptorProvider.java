package de.mkammerer.poc.jersey2guice.providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

/**
 * Created by iranna on 9-8-16.
 */
@Provider
public class WriterInterceptorProvider implements WriterInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(WriterInterceptorProvider.class);

    @Override
    public void aroundWriteTo(WriterInterceptorContext writerInterceptorContext) throws IOException, WebApplicationException {
        LOGGER.info("in reader interceptor {}", writerInterceptorContext.getOutputStream());
    }
}

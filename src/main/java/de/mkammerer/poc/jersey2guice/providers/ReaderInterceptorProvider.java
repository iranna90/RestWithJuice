package de.mkammerer.poc.jersey2guice.providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

/**
 * Created by iranna on 9-8-16.
 */
public class ReaderInterceptorProvider implements ReaderInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReaderInterceptorProvider.class);

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext readerInterceptorContext) throws IOException, WebApplicationException {
        LOGGER.info("in reader interceptor {}", readerInterceptorContext.getInputStream());
        return readerInterceptorContext;
    }
}

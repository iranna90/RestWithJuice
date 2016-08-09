package de.mkammerer.poc.jersey2guice.providers;

import de.mkammerer.poc.jersey2guice.datatypes.ShortDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 * Created by iranna on 9-8-16.
 */
@Provider
@Produces("text/shortdate")
public class MyShortDateMediaTypeProvider implements MessageBodyWriter<ShortDate> {

    Logger LOGGER = LoggerFactory.getLogger(MyShortDateMediaTypeProvider.class);

    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        LOGGER.info("Message body writer is writable {} ", aClass.getName());
        boolean assignableFrom = aClass.getSimpleName().equals(ShortDate.class.getSimpleName());
        LOGGER.info("writable {} and {} ", assignableFrom, type.getClass().getName());
        return assignableFrom;
    }

    public void writeTo(ShortDate shortDate, Class<?> aClass, Type type,
                        Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> multivaluedMap,
                        OutputStream outputStream) throws IOException, WebApplicationException {
        LOGGER.info("Message body writter");
        outputStream.write(shortDate.toString().getBytes());
    }

    public long getSize(ShortDate shortDate, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }
}

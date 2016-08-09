package de.mkammerer.poc.jersey2guice.providers;

import de.mkammerer.poc.jersey2guice.datatypes.ShortDate;

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

    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return type.getClass().isAssignableFrom(aClass);
    }

    public void writeTo(ShortDate shortDate, Class<?> aClass, Type type,
                        Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> multivaluedMap,
                        OutputStream outputStream) throws IOException, WebApplicationException {
        outputStream.write(shortDate.toString().getBytes());
    }

    public long getSize(ShortDate shortDate, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }
}

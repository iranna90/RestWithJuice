package de.mkammerer.poc.jersey2guice.providers;

import de.mkammerer.poc.jersey2guice.datatypes.ShortDate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

/**
 * Created by iranna on 10-8-16.
 */
@Provider
public class CustomParamConverterProvider implements ParamConverterProvider {
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> aClass, Type type, Annotation[] annotations) {
        return aClass != ShortDate.class ? null : (ParamConverter<T>) new CustomParamConverter();
    }
}

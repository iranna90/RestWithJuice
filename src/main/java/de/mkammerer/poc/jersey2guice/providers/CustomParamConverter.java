package de.mkammerer.poc.jersey2guice.providers;

import de.mkammerer.poc.jersey2guice.datatypes.ShortDate;

import java.time.LocalDate;

import javax.ws.rs.ext.ParamConverter;

/**
 * Created by iranna on 10-8-16.
 */
public class CustomParamConverter implements ParamConverter<ShortDate> {
    @Override
    public ShortDate fromString(String s) {
        LocalDate localDate = LocalDate.now();
        return s.equals("today") ? new ShortDate(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth()) :
                (s.equals("tomorrow") ? new ShortDate(localDate.getYear(), localDate.getMonthValue(), localDate.plusDays(1).getDayOfMonth()) :
                        (s.equals("previous") ? new ShortDate(localDate.getYear(), localDate.getMonthValue(), localDate.minusDays(1).getDayOfMonth()) : null));
    }

    @Override
    public String toString(ShortDate shortDate) {
        return shortDate.toString();
    }
}

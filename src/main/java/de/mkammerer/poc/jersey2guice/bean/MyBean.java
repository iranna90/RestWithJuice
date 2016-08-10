package de.mkammerer.poc.jersey2guice.bean;

import de.mkammerer.poc.jersey2guice.datatypes.ShortDate;

import javax.ws.rs.PathParam;

/**
 * Created by iranna on 10-8-16.
 */
public class MyBean {

    @PathParam("name")
    private String name;

    @PathParam("day")
    private ShortDate shortDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShortDate getShortDate() {
        return shortDate;
    }

    public void setShortDate(ShortDate shortDate) {
        this.shortDate = shortDate;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                ", shortDate=" + shortDate +
                '}';
    }
}

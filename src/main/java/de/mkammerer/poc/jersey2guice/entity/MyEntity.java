package de.mkammerer.poc.jersey2guice.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Created by iranna.patil on 13-08-2016.
 */
@Entity
@Table(name = "mytable")
public class MyEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
    @SequenceGenerator(name = "myseq", sequenceName = "myseq", initialValue = 1, allocationSize = 50)
    private long id;

    @Column(name = "datetime")
    private ZonedDateTime zonedDateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "id=" + id +
                ", zonedDateTime=" + zonedDateTime +
                '}';
    }
}

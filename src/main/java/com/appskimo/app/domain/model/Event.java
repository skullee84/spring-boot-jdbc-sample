package com.appskimo.app.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by dominic on 2016. 9. 23..
 */
@Data
@ToString(of = "name")
@NoArgsConstructor
public class Event implements Serializable {
    private static final long serialVersionUID = -4318248154624752739L;

    private String name;

    public Event(String name) {
        this.name = name;
    }

}

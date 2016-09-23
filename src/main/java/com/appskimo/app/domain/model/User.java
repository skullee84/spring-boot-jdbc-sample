package com.appskimo.app.domain.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by dominic on 2016. 9. 23..
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 8214786354841940252L;

    private Long id;
    private String name;
}

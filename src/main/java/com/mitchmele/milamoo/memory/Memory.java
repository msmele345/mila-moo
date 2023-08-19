package com.mitchmele.milamoo.memory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;


@Entity
public class Memory {

    public Memory() {}

    public Memory(String imgsrc, String description, Date date) {
        this.imgsrc = imgsrc;
        this.description = description;
        this.date = date;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String imgsrc;
    private String description;
    private Date date;
}

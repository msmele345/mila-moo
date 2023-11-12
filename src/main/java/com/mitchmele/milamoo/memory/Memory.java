package com.mitchmele.milamoo.memory;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@Entity
public class Memory implements Serializable {

    public Memory() {}

    public Memory(String imgsrc, String description, Date date) {
        this.imgsrc = imgsrc;
        this.description = description;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imgsrc;
    private String description;
    private Date date;
}

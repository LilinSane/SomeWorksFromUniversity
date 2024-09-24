package com.example.lab4server.database.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "point")
@Getter @Setter
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Point() {
    }

    public Point(float x, float y, float r, boolean result, long workTime, String currTime, String email) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = result;
        this.workTime = workTime;
        this.currTime = currTime;
        this.email = email;
    }

    private float x;
    private float y;
    private float r;
    private boolean hit;
    private long workTime;
    private String currTime;
    private String email;

}

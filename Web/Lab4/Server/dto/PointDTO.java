package com.example.lab4server.dto;

public class PointDTO {
    private Object x;
    private Object y;
    private Object r;
    private String email;

    public PointDTO(Object x, Object y, Object r, String email) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.email = email;
    }

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }

    public Object getR() {
        return r;
    }

    public void setR(Object r) {
        this.r = r;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

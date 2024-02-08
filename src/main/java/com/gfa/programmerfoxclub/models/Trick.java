package com.gfa.programmerfoxclub.models;

public class Trick {
    private String trickName;

    public Trick(String trickName) {
        this.trickName = trickName;
    }

    public Trick() {
    }

    public String getTrickName() {
        return trickName;
    }

    public void setTrickName(String trickName) {
        this.trickName = trickName;
    }
}

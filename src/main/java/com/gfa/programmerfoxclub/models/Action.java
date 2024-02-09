package com.gfa.programmerfoxclub.models;

import java.time.LocalDateTime;

public class Action {
    private String type;
    private String item;
    private LocalDateTime time;

    public void setActionType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Action(String type, String item, LocalDateTime time) {
        this.type = type;
        this.item = item;
        this.time = time;
    }
}

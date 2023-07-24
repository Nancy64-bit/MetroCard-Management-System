package com.geektrust.backend.entities;

public class Station {
    private String name;
    private String location;

    public Station(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

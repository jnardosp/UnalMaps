package com.poo.unalmaps;

import java.util.List;

public class Place {
    private String name;
    private List nickNames;
    private String description;
    private Point placePoint;
    private List placeEntries;
    private String buildingNumber;
    private String faculty;
    private boolean approved = false;

    public Place (String name, List nickNames, String description, Point placePoint, List placeEntries,
    String buildingNumber, String faculty) {
        this.name = name;
        this.nickNames = nickNames;
        this.description = description;
        this.placePoint = placePoint;
        this.placeEntries = placeEntries;
        this.buildingNumber = buildingNumber;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public List getNickNames() {
        return nickNames;
    }

    public String getDescription() {
        return description;
    }

    public Point getUbicationPoint() {
        return placePoint;
    }

    public List getPlaceEntries() {
        return placeEntries;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getFaculty() {
        return faculty;
    }
}

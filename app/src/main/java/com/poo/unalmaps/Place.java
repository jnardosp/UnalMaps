package com.poo.unalmaps;

import java.util.List;

public class Place {
    private final String name;
    private final List nickNames;
    private final String description;
    private final Point placePoint;
    private final List placeEntries;
    private final String buildingNumber;
    private final String faculty;
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

    public Point getPlacePoint() {
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

    public boolean isApproved() {
        return approved;
    }

    private void setApproved(boolean approved) {
        this.approved = approved;
    }
}

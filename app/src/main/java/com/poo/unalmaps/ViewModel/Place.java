package com.poo.unalmaps.ViewModel;

import java.util.List;

//Made by N0chez
public class Place {
    private final String name;
    private final String nickNames;
    private final String description;
    private final Point placePoint;
    //private final List placeEntries;
    private final String buildingNumber;
    private final String faculty;
    private boolean approved = false;

    public Place (String name, String nickNames, String description, Point placePoint, //List placeEntries,
                  String buildingNumber, String faculty) {
        this.name = name;
        this.nickNames = nickNames;
        this.description = description;
        this.placePoint = placePoint;
        //this.placeEntries = placeEntries;
        this.buildingNumber = buildingNumber;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public String getNickNames() {
        return nickNames;
    }

    public String getDescription() {
        return description;
    }

    public Point getPlacePoint() {
        return placePoint;
    }

    /*public List getPlaceEntries() {
        return placeEntries;
    }*/

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
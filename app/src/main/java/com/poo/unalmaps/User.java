package com.poo.unalmaps;

import java.util.List;

public class User {
    private String name;
    private Point userPoint;
    private List lastPlaces;
    private boolean accessibility = true;

    public User (String name, Point userPoint,List lastPlaces, boolean accessibility) {
        this.name = name;
        this.userPoint = userPoint;
        this.lastPlaces = lastPlaces;
    }

    // public Place addPlace() {}

    //public String showDevInfo() {}

    //public void setSearchN() {}

    public void setUserPoint(Point userPoint) {
        this.userPoint = userPoint;
    }

    public void setAccessibility(boolean accessibility) {
        this.accessibility = accessibility;
    }

    public String getName() {
        return name;
    }

    public Point getUserPoint() {
        return userPoint;
    }

    //public boolean getAccessibility() {}

    public List getLastPlaces() {
        return lastPlaces;
    }
}

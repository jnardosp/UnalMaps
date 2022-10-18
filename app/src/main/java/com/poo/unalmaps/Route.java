package com.poo.unalmaps;

public class Route {
    private Point startingPoint;
    private Point destinationPoint;
    public int estimatedTime = 0;

    public Route (Point startingPoint, Point destinationPoint) {
        this.startingPoint = startingPoint;
        this.destinationPoint = destinationPoint;
    }

    public void setDestinationPoint(Point destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public void startRoute () {

    }
}

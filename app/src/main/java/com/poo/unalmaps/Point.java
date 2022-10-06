package com.poo.unalmaps;

public class Point {
    private float coordX;
    private float coordY;

    public Point (float x, float y) {
        this.coordX = x;
        this.coordY = y;
    }

    public Float getCoordX() {
        return coordX;
    }

    public Float getCoordY() {
        return coordY;
    }

    public void setCoordX(Float coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(Float coordY) {
        this.coordY = coordY;
    }
}

package com.poo.unalmaps.ViewModel;

//Made by N0chez
public class Point {
    private float cordX;
    private float cordY;

    public Point (float x, float y) {
        this.cordX = x;
        this.cordY = y;
    }

    public Float getCordX() {
        return cordX;
    }

    public Float getCordY() {
        return cordY;
    }

    public void setCordX(Float cordX) {
        this.cordX = cordX;
    }

    public void setCordY(Float cordY) {
        this.cordY = cordY;
    }
}
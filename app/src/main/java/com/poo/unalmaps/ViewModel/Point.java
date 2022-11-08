package com.poo.unalmaps.ViewModel;

//Made by N0chez
public class Point {
    private double cordX;
    private double cordY;

    public Point (double x, double y) {
        this.cordX = x;
        this.cordY = y;
    }

    public Double getCordX() {
        return cordX;
    }

    public Double getCordY() {
        return cordY;
    }

    public void setCordX(Float cordX) {
        this.cordX = cordX;
    }

    public void setCordY(Float cordY) {
        this.cordY = cordY;
    }
}
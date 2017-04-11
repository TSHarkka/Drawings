package com.example.kayttaja.drawings;

/**
 * Created by kayttaja on 11/04/2017.
 */

class Point {
    float x, y;

    @Override
    public String toString() { return x + ", " + y;}

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }
}

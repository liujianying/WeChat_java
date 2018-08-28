package com.tencent.map.lib.basemap.data;

public class DoublePoint {
    public double x;
    public double y;

    public DoublePoint(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public void set(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DoublePoint)) {
            return false;
        }
        DoublePoint doublePoint = (DoublePoint) obj;
        if (this.x == doublePoint.x && this.y == doublePoint.y) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.x + "," + this.y;
    }
}

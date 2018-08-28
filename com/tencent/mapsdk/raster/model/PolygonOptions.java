package com.tencent.mapsdk.raster.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions {
    private int fillColor = -16777216;
    private boolean isVisible = true;
    private final List<LatLng> points = new ArrayList();
    private int strokeColor = -16777216;
    private float strokeWidth = 10.0f;
    private float zIndex = 0.0f;

    public final PolygonOptions add(LatLng latLng) {
        if (latLng != null) {
            this.points.add(latLng);
        }
        return this;
    }

    public final PolygonOptions add(LatLng... latLngArr) {
        if (latLngArr != null) {
            this.points.addAll(Arrays.asList(latLngArr));
        }
        return this;
    }

    public final PolygonOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            for (LatLng add : iterable) {
                this.points.add(add);
            }
        }
        return this;
    }

    public final PolygonOptions strokeWidth(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.strokeWidth = f;
        return this;
    }

    public final PolygonOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public final PolygonOptions fillColor(int i) {
        this.fillColor = i;
        return this;
    }

    public final PolygonOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }

    public final PolygonOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public final List<LatLng> getPoints() {
        return this.points;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }
}

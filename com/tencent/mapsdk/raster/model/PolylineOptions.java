package com.tencent.mapsdk.raster.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions {
    private float arrowGap = 90.0f;
    private BitmapDescriptor arrowTexture;
    private int color = -16777216;
    private int edgeColor = -983041;
    private float edgeWidth = 0.0f;
    private boolean isDottedLine = false;
    private boolean isGeodesic = false;
    private boolean isVisible = true;
    private final List<LatLng> points = new ArrayList();
    private float width = 10.0f;
    private float zIndex = 0.0f;

    public final PolylineOptions arrowGap(float f) {
        if (f > 0.0f) {
            this.arrowGap = f;
        }
        return this;
    }

    public final PolylineOptions arrowTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.arrowTexture = bitmapDescriptor;
        }
        return this;
    }

    public final BitmapDescriptor getArrowTexture() {
        return this.arrowTexture;
    }

    public final PolylineOptions edgeWidth(float f) {
        if (f > 0.0f) {
            this.edgeWidth = f;
        }
        return this;
    }

    public final float getEdgeWidth() {
        return this.edgeWidth;
    }

    public final PolylineOptions edgeColor(int i) {
        this.edgeColor = i;
        return this;
    }

    public final int getEdgeColor() {
        return this.edgeColor;
    }

    public final float getArrowGap() {
        return this.arrowGap;
    }

    public final PolylineOptions add(LatLng latLng) {
        if (latLng != null) {
            this.points.add(latLng);
        }
        return this;
    }

    public final PolylineOptions add(LatLng... latLngArr) {
        if (latLngArr != null) {
            this.points.addAll(Arrays.asList(latLngArr));
        }
        return this;
    }

    public final PolylineOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            for (LatLng add : iterable) {
                this.points.add(add);
            }
        }
        return this;
    }

    public final PolylineOptions width(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.width = f;
        return this;
    }

    public final PolylineOptions color(int i) {
        this.color = i;
        return this;
    }

    public final PolylineOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }

    public final PolylineOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public final PolylineOptions geodesic(boolean z) {
        this.isGeodesic = z;
        return this;
    }

    public final List<LatLng> getPoints() {
        return this.points;
    }

    public final float getWidth() {
        return this.width;
    }

    public final int getColor() {
        return this.color;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final PolylineOptions setDottedLine(boolean z) {
        this.isDottedLine = z;
        return this;
    }

    public final boolean isDottedLine() {
        return this.isDottedLine;
    }

    public final boolean isGeodesic() {
        return this.isGeodesic;
    }
}

package com.tencent.mapsdk.raster.model;

import com.tencent.tencentmap.mapsdk.a.h;

public final class VisibleRegion {
    private final LatLng farLeft;
    private final LatLng farRight;
    private final LatLngBounds latLngBounds;
    private final int mVersionCode;
    private final LatLng nearLeft;
    private final LatLng nearRight;

    protected VisibleRegion(int i, LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.mVersionCode = i;
        this.nearLeft = latLng;
        this.nearRight = latLng2;
        this.farLeft = latLng3;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds;
    }

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this(1, latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    public final int hashCode() {
        return h.a(new Object[]{getNearLeft(), getNearRight(), getFarLeft(), getFarRight(), getLatLngBounds()});
    }

    protected final int getVersionCode() {
        return this.mVersionCode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        if (getNearLeft().equals(visibleRegion.getNearLeft()) && getNearRight().equals(visibleRegion.getNearRight()) && getFarLeft().equals(visibleRegion.getFarLeft()) && getFarRight().equals(visibleRegion.getFarRight()) && getLatLngBounds().equals(visibleRegion.getLatLngBounds())) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return h.a(h.a("nearLeft", getNearLeft()), h.a("nearRight", getNearRight()), h.a("farLeft", getFarLeft()), h.a("farRight", getFarRight()), h.a("latLngBounds", getLatLngBounds()));
    }

    public final LatLng getNearLeft() {
        return this.nearLeft;
    }

    public final LatLng getNearRight() {
        return this.nearRight;
    }

    public final LatLng getFarLeft() {
        return this.farLeft;
    }

    public final LatLng getFarRight() {
        return this.farRight;
    }

    public final LatLngBounds getLatLngBounds() {
        return this.latLngBounds;
    }
}

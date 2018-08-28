package com.tencent.mapsdk.raster.model;

import com.tencent.tencentmap.mapsdk.a.h;

public class LatLngBounds {
    private int mVersionCode;
    private LatLng northeast;
    private LatLng southwest;

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        Builder include = new Builder().include(latLng).include(latLng2);
        this.southwest = new LatLng(Builder.access$000(include), Builder.access$100(include));
        this.northeast = new LatLng(Builder.access$200(include), Builder.access$300(include));
        this.mVersionCode = i;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public LatLng getSouthwest() {
        return this.southwest;
    }

    public LatLng getNortheast() {
        return this.northeast;
    }

    public boolean contains(LatLng latLng) {
        return containsLatitude(latLng.getLatitude()) && containsLongitude(latLng.getLongitude());
    }

    public boolean contains(LatLngBounds latLngBounds) {
        if (latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast)) {
            return true;
        }
        return false;
    }

    public boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return false;
        }
        if (intersect(latLngBounds) || latLngBounds.intersect(this)) {
            return true;
        }
        return false;
    }

    private boolean intersect(LatLngBounds latLngBounds) {
        if (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null || this.northeast == null || this.southwest == null) {
            return false;
        }
        double latitude = ((latLngBounds.northeast.getLatitude() + latLngBounds.southwest.getLatitude()) - this.northeast.getLatitude()) - this.southwest.getLatitude();
        double latitude2 = ((this.northeast.getLatitude() - this.southwest.getLatitude()) + latLngBounds.northeast.getLatitude()) - latLngBounds.southwest.getLatitude();
        if (Math.abs(((latLngBounds.northeast.getLongitude() + latLngBounds.southwest.getLongitude()) - this.northeast.getLongitude()) - this.southwest.getLongitude()) >= ((this.northeast.getLongitude() - this.southwest.getLongitude()) + latLngBounds.northeast.getLongitude()) - latLngBounds.southwest.getLongitude() || Math.abs(latitude) >= latitude2) {
            return false;
        }
        return true;
    }

    public LatLngBounds including(LatLng latLng) {
        double min = Math.min(this.southwest.getLatitude(), latLng.getLatitude());
        double max = Math.max(this.northeast.getLatitude(), latLng.getLatitude());
        double longitude = this.northeast.getLongitude();
        double longitude2 = this.southwest.getLongitude();
        double longitude3 = latLng.getLongitude();
        if (!containsLongitude(longitude3)) {
            if (longitudeDistanceHeadingWest(longitude2, longitude3) < longitudeDistanceHeadingEast(longitude, longitude3)) {
                longitude2 = longitude3;
            } else {
                longitude = longitude3;
            }
        }
        return new LatLngBounds(new LatLng(min, longitude2), new LatLng(max, longitude));
    }

    private static double longitudeDistanceHeadingWest(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    private static double longitudeDistanceHeadingEast(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    private boolean containsLatitude(double d) {
        return this.southwest.getLatitude() <= d && d <= this.northeast.getLatitude();
    }

    private boolean containsLongitude(double d) {
        if (this.southwest.getLongitude() <= this.northeast.getLongitude()) {
            if (this.southwest.getLongitude() > d || d > this.northeast.getLongitude()) {
                return false;
            }
            return true;
        } else if (this.southwest.getLongitude() <= d || d <= this.northeast.getLongitude()) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return h.a(new Object[]{this.southwest, this.northeast});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        if (this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return h.a(new String[]{h.a("southwest", this.southwest), h.a("northeast", this.northeast)});
    }
}

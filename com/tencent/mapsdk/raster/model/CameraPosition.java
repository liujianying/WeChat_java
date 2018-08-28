package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.tencentmap.mapsdk.a.h;

public final class CameraPosition implements Parcelable {
    public static final Creator<CameraPosition> CREATOR = new 1();
    private static final int EMPTY_ZOOMLEVEL = -1;
    private final LatLng target;
    private float zoom = -1.0f;

    public CameraPosition(LatLng latLng, float f) {
        this.target = latLng;
        this.zoom = f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat((float) getTarget().getLatitude());
        parcel.writeFloat((float) getTarget().getLongitude());
        parcel.writeFloat(getZoom());
    }

    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f) {
        return new CameraPosition(latLng, f);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        if (getTarget().equals(cameraPosition.getTarget()) && Float.floatToIntBits(getZoom()) == Float.floatToIntBits(cameraPosition.getZoom())) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return h.a(h.a("target", getTarget()), h.a("zoom", Float.valueOf(getZoom())));
    }

    public final LatLng getTarget() {
        return this.target;
    }

    public final float getZoom() {
        return this.zoom;
    }
}

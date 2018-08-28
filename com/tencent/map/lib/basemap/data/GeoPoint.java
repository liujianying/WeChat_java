package com.tencent.map.lib.basemap.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GeoPoint implements Parcelable {
    public static final Creator<GeoPoint> CREATOR = new Creator<GeoPoint>() {
        /* renamed from: a */
        public final GeoPoint createFromParcel(Parcel parcel) {
            return new GeoPoint(parcel, null);
        }

        /* renamed from: a */
        public final GeoPoint[] newArray(int i) {
            return new GeoPoint[i];
        }
    };
    private int mLatitudeE6;
    private int mLongitudeE6;

    public GeoPoint() {
        this.mLatitudeE6 = -85000001;
        this.mLongitudeE6 = -180000001;
    }

    public GeoPoint(GeoPoint geoPoint) {
        this();
        this.mLatitudeE6 = geoPoint.mLatitudeE6;
        this.mLongitudeE6 = geoPoint.mLongitudeE6;
    }

    public GeoPoint(int i, int i2) {
        this.mLatitudeE6 = i;
        this.mLongitudeE6 = i2;
    }

    public int getLatitudeE6() {
        return this.mLatitudeE6;
    }

    public int getLongitudeE6() {
        return this.mLongitudeE6;
    }

    public void setLatitudeE6(int i) {
        this.mLatitudeE6 = i;
    }

    public void setLongitudeE6(int i) {
        this.mLongitudeE6 = i;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.mLatitudeE6 = geoPoint.getLatitudeE6();
        this.mLongitudeE6 = geoPoint.getLongitudeE6();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoPoint)) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (this.mLatitudeE6 == geoPoint.mLatitudeE6 && this.mLongitudeE6 == geoPoint.mLongitudeE6) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.mLatitudeE6 + "," + this.mLongitudeE6;
    }

    public static GeoPoint formString(String str) {
        GeoPoint geoPoint = new GeoPoint();
        if (str != null) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length == 2) {
                    geoPoint.mLatitudeE6 = Integer.parseInt(split[0]);
                    geoPoint.mLongitudeE6 = Integer.parseInt(split[1]);
                }
            } catch (Exception e) {
            }
        }
        return geoPoint;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mLatitudeE6);
        parcel.writeInt(this.mLongitudeE6);
    }

    private GeoPoint(Parcel parcel) {
        this.mLatitudeE6 = parcel.readInt();
        this.mLongitudeE6 = parcel.readInt();
    }
}

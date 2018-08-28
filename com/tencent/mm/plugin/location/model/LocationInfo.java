package com.tencent.mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.bi;

public class LocationInfo implements Parcelable {
    public static final Creator<LocationInfo> CREATOR = new 1();
    public String bWB;
    public String kCA;
    String kCB;
    public int kCC;
    public String kCv;
    public double kCw;
    public double kCx;
    public int kCy;
    public String kCz;

    public LocationInfo() {
        this.kCv = "";
        this.kCw = -85.0d;
        this.kCx = -1000.0d;
        this.kCz = "";
        this.kCA = "zh-cn";
        this.kCB = "";
        this.kCC = 0;
    }

    public LocationInfo(byte b) {
        this.kCv = "";
        this.kCw = -85.0d;
        this.kCx = -1000.0d;
        this.kCz = "";
        this.kCA = "zh-cn";
        this.kCB = "";
        this.kCC = 0;
        this.kCv = toString() + " " + System.nanoTime();
        this.kCy = d.aZx();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.kCv);
        parcel.writeDouble(this.kCw);
        parcel.writeDouble(this.kCx);
        parcel.writeInt(this.kCy);
        parcel.writeString(this.kCz);
        parcel.writeString(this.kCA);
        parcel.writeString(this.bWB);
        parcel.writeString(this.kCB);
        parcel.writeInt(this.kCC);
    }

    public final boolean aYY() {
        if (this.kCw == -85.0d || this.kCx == -1000.0d) {
            return false;
        }
        return true;
    }

    public final boolean aYZ() {
        if (bi.oW(this.kCz) && bi.oW(this.bWB)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.kCw + " " + this.kCx + " " + this.kCz + " " + this.bWB + "  " + this.kCv;
    }

    public int describeContents() {
        return 0;
    }
}

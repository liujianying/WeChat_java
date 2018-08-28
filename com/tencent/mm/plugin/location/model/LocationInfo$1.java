package com.tencent.mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class LocationInfo$1 implements Creator<LocationInfo> {
    LocationInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        LocationInfo locationInfo = new LocationInfo();
        locationInfo.kCv = parcel.readString();
        locationInfo.kCw = parcel.readDouble();
        locationInfo.kCx = parcel.readDouble();
        locationInfo.kCy = parcel.readInt();
        locationInfo.kCz = parcel.readString();
        locationInfo.kCA = parcel.readString();
        locationInfo.bWB = parcel.readString();
        locationInfo.kCB = parcel.readString();
        locationInfo.kCC = parcel.readInt();
        return locationInfo;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LocationInfo[i];
    }
}

package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class LaunchParamsOptional implements Parcelable {
    public static final Creator<LaunchParamsOptional> CREATOR = new 1();
    public String dFy;
    public String dFz;
    public String dzR;

    /* synthetic */ LaunchParamsOptional(Parcel parcel, byte b) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dFy);
        parcel.writeString(this.dzR);
    }

    private LaunchParamsOptional(Parcel parcel) {
        this.dFy = parcel.readString();
        this.dzR = parcel.readString();
    }
}

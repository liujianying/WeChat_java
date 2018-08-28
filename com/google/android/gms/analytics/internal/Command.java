package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command implements Parcelable {
    @Deprecated
    public static final Creator<Command> CREATOR = new 1();
    String aEN;
    private String aEO;
    String mValue;

    @Deprecated
    Command(Parcel parcel) {
        this.aEN = parcel.readString();
        this.aEO = parcel.readString();
        this.mValue = parcel.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aEN);
        parcel.writeString(this.aEO);
        parcel.writeString(this.mValue);
    }
}

package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class StringToIntConverter$Entry implements SafeParcelable {
    public static final c CREATOR = new c();
    final String aOT;
    final int aOU;
    final int versionCode;

    StringToIntConverter$Entry(int i, String str, int i2) {
        this.versionCode = i;
        this.aOT = str;
        this.aOU = i2;
    }

    StringToIntConverter$Entry(String str, int i) {
        this.versionCode = 1;
        this.aOT = str;
        this.aOU = i;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel);
    }
}

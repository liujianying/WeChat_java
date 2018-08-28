package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class RuntimeLoadModuleTask$LoadParams implements Parcelable {
    public static final Creator<RuntimeLoadModuleTask$LoadParams> CREATOR = new 1();
    public final String appId;
    public final int bPh;
    public final String fgp;
    public final int fii;

    /* synthetic */ RuntimeLoadModuleTask$LoadParams(String str, int i, int i2, String str2, byte b) {
        this(str, i, i2, str2);
    }

    private RuntimeLoadModuleTask$LoadParams(String str, int i, int i2, String str2) {
        this.appId = str;
        this.bPh = i;
        this.fii = i2;
        this.fgp = str2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.bPh);
        parcel.writeInt(this.fii);
        parcel.writeString(this.fgp);
    }

    RuntimeLoadModuleTask$LoadParams(Parcel parcel) {
        this.appId = parcel.readString();
        this.bPh = parcel.readInt();
        this.fii = parcel.readInt();
        this.fgp = parcel.readString();
    }
}

package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LocalUsageInfo implements Parcelable {
    public static final Creator<LocalUsageInfo> CREATOR = new 1();
    public final String appId;
    public final String fmD;
    public final int fmv;
    public final String nickname;
    public final String username;

    /* synthetic */ LocalUsageInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public LocalUsageInfo(String str, String str2, int i, String str3, String str4) {
        this.username = str;
        this.appId = str2;
        this.fmv = i;
        this.nickname = str3;
        this.fmD = str4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeInt(this.fmv);
        parcel.writeString(this.nickname);
        parcel.writeString(this.fmD);
    }

    private LocalUsageInfo(Parcel parcel) {
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.fmv = parcel.readInt();
        this.nickname = parcel.readString();
        this.fmD = parcel.readString();
    }
}

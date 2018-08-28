package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.d;

public final class LaunchBroadCast implements Parcelable {
    public static final Creator<LaunchBroadCast> CREATOR = new 1();
    public String appId;
    public boolean cdk;
    public int fmv;
    public int gfw;
    public String username;

    /* synthetic */ LaunchBroadCast(Parcel parcel, byte b) {
        this(parcel);
    }

    static void a(String str, int i, int i2, boolean z) {
        Parcelable launchBroadCast = new LaunchBroadCast();
        launchBroadCast.username = null;
        launchBroadCast.appId = str;
        launchBroadCast.fmv = i;
        launchBroadCast.gfw = i2;
        launchBroadCast.cdk = z;
        d.c(launchBroadCast);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeInt(this.fmv);
        parcel.writeInt(this.gfw);
        parcel.writeByte(this.cdk ? (byte) 1 : (byte) 0);
    }

    private LaunchBroadCast() {
    }

    private LaunchBroadCast(Parcel parcel) {
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.fmv = parcel.readInt();
        this.gfw = parcel.readInt();
        this.cdk = parcel.readByte() != (byte) 0;
    }
}

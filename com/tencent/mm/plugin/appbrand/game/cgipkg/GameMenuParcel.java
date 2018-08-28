package com.tencent.mm.plugin.appbrand.game.cgipkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.protocal.c.adz;

public class GameMenuParcel implements Parcelable {
    public static final Creator<GameMenuParcel> CREATOR = new 1();
    public String appId;
    public adz fAA;

    /* synthetic */ GameMenuParcel(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        c.a(this.fAA, parcel);
    }

    private GameMenuParcel(Parcel parcel) {
        this.appId = parcel.readString();
        this.fAA = (adz) c.a(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName(), parcel);
    }
}

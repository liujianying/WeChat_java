package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameFloatLayerInfo implements Parcelable {
    public static final Creator<GameFloatLayerInfo> CREATOR = new 1();
    public boolean jMc;
    public int orientation;
    public String url;

    /* synthetic */ GameFloatLayerInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeInt(this.jMc ? 1 : 0);
        parcel.writeInt(this.orientation);
    }

    private GameFloatLayerInfo(Parcel parcel) {
        boolean z = true;
        this.url = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.jMc = z;
        this.orientation = parcel.readInt();
    }
}

package com.tencent.mm.plugin.game.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class WepkgVersionManager$WepkgNetSceneProcessTask$WepkgCheckReq implements Parcelable {
    public static final Creator<WepkgVersionManager$WepkgNetSceneProcessTask$WepkgCheckReq> CREATOR = new 1();
    private String kfA;
    private int scene;
    private String version;

    /* synthetic */ WepkgVersionManager$WepkgNetSceneProcessTask$WepkgCheckReq(Parcel parcel, byte b) {
        this(parcel);
    }

    private WepkgVersionManager$WepkgNetSceneProcessTask$WepkgCheckReq() {
    }

    private WepkgVersionManager$WepkgNetSceneProcessTask$WepkgCheckReq(Parcel parcel) {
        this.kfA = parcel.readString();
        this.version = parcel.readString();
        this.scene = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.kfA);
        parcel.writeString(this.version);
        parcel.writeInt(this.scene);
    }
}

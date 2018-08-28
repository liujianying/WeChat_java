package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameTabData$TabItem implements Parcelable {
    public static final Creator<GameTabData$TabItem> CREATOR = new 1();
    public int bYq;
    public String jLt;
    public String jOl;
    public boolean jOm;
    public boolean jOn;
    public int jOo;
    public int jOp;
    public String jOq;
    public String jOr;
    public String jOs;
    public boolean jOt;
    public int jOu;
    public String jumpUrl;
    public String title;

    public GameTabData$TabItem(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.jOl = parcel.readString();
        this.title = parcel.readString();
        this.jumpUrl = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.jOm = z;
        this.jOn = parcel.readByte() != (byte) 0;
        this.jOo = parcel.readInt();
        this.jOp = parcel.readInt();
        this.jOq = parcel.readString();
        this.jOr = parcel.readString();
        this.jOs = parcel.readString();
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.jOt = z2;
        this.bYq = parcel.readInt();
        this.jOu = parcel.readInt();
        this.jLt = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.jOl);
        parcel.writeString(this.title);
        parcel.writeString(this.jumpUrl);
        parcel.writeByte((byte) (this.jOm ? 1 : 0));
        if (this.jOn) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.jOo);
        parcel.writeInt(this.jOp);
        parcel.writeString(this.jOq);
        parcel.writeString(this.jOr);
        parcel.writeString(this.jOs);
        if (!this.jOt) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(this.bYq);
        parcel.writeInt(this.jOu);
        parcel.writeString(this.jLt);
    }
}

package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import d.a.a.c;

public class Orders$Promotions implements Parcelable {
    public static final Creator<Orders$Promotions> CREATOR = new 1();
    public String lNW;
    public String lRX;
    public String name;
    public long pji;
    public int poD;
    public int poE;
    public long poF;
    public String poG;
    public int ppS;
    public int ppT;
    public int ppU;
    public String ppV;
    public String ppW;
    public String ppX;
    public int ppY;
    public String ppZ;
    public String pqa;
    public c pqb;
    public String title;
    public int type;
    public String url;

    public Orders$Promotions(Parcel parcel) {
        this.type = parcel.readInt();
        this.lRX = parcel.readString();
        this.name = parcel.readString();
        this.poG = parcel.readString();
        this.url = parcel.readString();
        this.lNW = parcel.readString();
        this.title = parcel.readString();
        this.ppS = parcel.readInt();
        this.pji = parcel.readLong();
        this.ppT = parcel.readInt();
        this.ppU = parcel.readInt();
        this.poD = parcel.readInt();
        this.poE = parcel.readInt();
        this.ppV = parcel.readString();
        this.ppW = parcel.readString();
        this.ppX = parcel.readString();
        this.poF = parcel.readLong();
        this.ppY = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.lRX);
        parcel.writeString(this.name);
        parcel.writeString(this.poG);
        parcel.writeString(this.url);
        parcel.writeString(this.lNW);
        parcel.writeString(this.title);
        parcel.writeInt(this.ppS);
        parcel.writeLong(this.pji);
        parcel.writeInt(this.ppT);
        parcel.writeInt(this.ppU);
        parcel.writeInt(this.poD);
        parcel.writeInt(this.poE);
        parcel.writeString(this.ppV);
        parcel.writeString(this.ppW);
        parcel.writeString(this.ppX);
        parcel.writeLong(this.poF);
        parcel.writeInt(this.ppY);
    }
}

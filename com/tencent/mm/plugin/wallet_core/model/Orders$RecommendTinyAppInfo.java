package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Orders$RecommendTinyAppInfo implements Parcelable {
    public static final Creator<Orders$RecommendTinyAppInfo> CREATOR = new 1();
    public String paD;
    public String paE;
    public String poI;
    public String poJ;
    public String poK;
    public String poL;
    public int poM;
    public long pqc;
    public long pqd;
    public long pqe;
    public int pqf;
    public int pqg;
    public long pqh;

    public Orders$RecommendTinyAppInfo(Parcel parcel) {
        this.poI = parcel.readString();
        this.poJ = parcel.readString();
        this.poK = parcel.readString();
        this.paD = parcel.readString();
        this.paE = parcel.readString();
        this.poM = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.poI);
        parcel.writeString(this.poJ);
        parcel.writeString(this.poK);
        parcel.writeString(this.paD);
        parcel.writeString(this.paE);
        parcel.writeInt(this.poM);
    }
}

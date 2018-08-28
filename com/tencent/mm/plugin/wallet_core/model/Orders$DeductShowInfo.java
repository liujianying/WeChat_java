package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Orders$DeductShowInfo implements Parcelable {
    public static final Creator<Orders$DeductShowInfo> CREATOR = new 1();
    public String name;
    public int ppN;
    public String ppO;
    public String ppP;
    public String ppQ;
    public String value;

    protected Orders$DeductShowInfo(Parcel parcel) {
        this.name = parcel.readString();
        this.value = parcel.readString();
        this.ppN = parcel.readInt();
        this.ppO = parcel.readString();
        this.ppP = parcel.readString();
        this.ppQ = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.value);
        parcel.writeInt(this.ppN);
        parcel.writeString(this.ppO);
        parcel.writeString(this.ppP);
        parcel.writeString(this.ppQ);
    }
}

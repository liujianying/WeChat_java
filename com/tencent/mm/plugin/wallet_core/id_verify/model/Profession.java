package com.tencent.mm.plugin.wallet_core.id_verify.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Profession implements Parcelable {
    public static final Creator<Profession> CREATOR = new 1();
    public String pkT;
    public int pkU;

    public Profession(String str, int i) {
        this.pkT = str;
        this.pkU = i;
    }

    protected Profession(Parcel parcel) {
        this.pkT = parcel.readString();
        this.pkU = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.pkT);
        parcel.writeInt(this.pkU);
    }
}

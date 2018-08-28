package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Parcel;
import android.os.Parcelable;

public class NetScenePayUElementQuery$PayUBankcardElement implements Parcelable {
    public String bST = "";
    public String cardType = "";
    public String lNT = "";
    public String pEc = "";
    public String pEd = "";

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.pEc);
        parcel.writeString(this.lNT);
        parcel.writeString(this.pEd);
        parcel.writeString(this.cardType);
        parcel.writeString(this.bST);
    }
}

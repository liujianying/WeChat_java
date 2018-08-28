package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Orders$RemarksInfo implements Parcelable {
    public static final Creator<Orders$RemarksInfo> CREATOR = new 1();
    public String pqi;
    public String pqj;

    protected Orders$RemarksInfo(Parcel parcel) {
        this.pqi = parcel.readString();
        this.pqj = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.pqi);
        parcel.writeString(this.pqj);
    }
}

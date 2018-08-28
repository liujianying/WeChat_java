package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SetPwdInfo implements Parcelable {
    public static final Creator<SetPwdInfo> CREATOR = new 1();
    public String kRt;
    public String kRu = "";
    public String kRv = "";
    public int plg;

    protected SetPwdInfo(Parcel parcel) {
        this.plg = parcel.readInt();
        this.kRt = parcel.readString();
        this.kRu = parcel.readString();
        this.kRv = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.plg);
        parcel.writeString(this.kRt);
        parcel.writeString(this.kRu);
        parcel.writeString(this.kRv);
    }

    public int describeContents() {
        return 0;
    }
}

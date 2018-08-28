package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ShareInfo implements Parcelable {
    public static final Creator<ShareInfo> CREATOR = new 1();
    public String dFy;
    public String dzR;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dzR);
        parcel.writeString(this.dFy);
    }

    public ShareInfo(String str, String str2) {
        this.dzR = str;
        this.dFy = str2;
    }

    private ShareInfo(Parcel parcel) {
        this.dzR = parcel.readString();
        this.dFy = parcel.readString();
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SendDataToMiniProgramFromH5Event implements Parcelable {
    public static final Creator<SendDataToMiniProgramFromH5Event> CREATOR = new 1();
    public String data;
    public String fQs;
    public int fQt;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fQs);
        parcel.writeString(this.data);
        parcel.writeInt(this.fQt);
    }

    protected SendDataToMiniProgramFromH5Event(Parcel parcel) {
        this.fQs = parcel.readString();
        this.data = parcel.readString();
        this.fQt = parcel.readInt();
    }
}

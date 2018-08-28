package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCAudioParamRequest implements Parcelable {
    public static final Creator<IPCAudioParamRequest> CREATOR = new 1();
    public int lxH = 0;
    public byte[] lxI;
    public String lxx = "";
    public String mimeType = "";

    public IPCAudioParamRequest(Parcel parcel) {
        this.lxx = parcel.readString();
        this.lxH = parcel.readInt();
        this.mimeType = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.lxI = new byte[readInt];
            parcel.readByteArray(this.lxI);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.lxx);
        parcel.writeInt(this.lxH);
        parcel.writeString(this.mimeType);
        if (this.lxI != null) {
            parcel.writeInt(this.lxI.length);
            parcel.writeByteArray(this.lxI);
            return;
        }
        parcel.writeInt(0);
    }
}

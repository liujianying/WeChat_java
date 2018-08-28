package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppBrandLocalMediaObject implements Parcelable {
    public static final Creator<AppBrandLocalMediaObject> CREATOR = new 1();
    public String bNH;
    public String dDG;
    public long eyz;
    public String fjS;
    public boolean fjT;
    public long fjU;
    public String mimeType;

    public String toString() {
        return "AppBrandLocalMediaObject{localId='" + this.bNH + '\'' + ", fileFullPath='" + this.dDG + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.fjS + '\'' + '}';
    }

    protected AppBrandLocalMediaObject() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bNH);
        parcel.writeString(this.dDG);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.fjS);
        parcel.writeByte(this.fjT ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.eyz);
        parcel.writeLong(this.fjU);
    }

    protected AppBrandLocalMediaObject(Parcel parcel) {
        this.bNH = parcel.readString();
        this.dDG = parcel.readString();
        this.mimeType = parcel.readString();
        this.fjS = parcel.readString();
        this.fjT = parcel.readByte() != (byte) 0;
        this.eyz = parcel.readLong();
        this.fjU = parcel.readLong();
    }
}

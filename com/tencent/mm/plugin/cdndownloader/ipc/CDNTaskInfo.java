package com.tencent.mm.plugin.cdndownloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CDNTaskInfo implements Parcelable {
    public static final Creator<CDNTaskInfo> CREATOR = new 1();
    public boolean dQc;
    public String downloadUrl;
    public String filePath;
    public String hKj;
    public String hKk;
    public int hKl;
    public int hKm;
    public boolean hKn;
    public boolean hKo;
    public boolean hKp;
    public String mediaId;

    /* synthetic */ CDNTaskInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        parcel.writeByte(this.dQc ? (byte) 1 : (byte) 0);
        parcel.writeString(this.downloadUrl);
        parcel.writeString(this.mediaId);
        parcel.writeString(this.filePath);
        parcel.writeString(this.hKj);
        parcel.writeString(this.hKk);
        parcel.writeInt(this.hKl);
        parcel.writeInt(this.hKm);
        if (this.hKn) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (!this.hKp) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
    }

    private CDNTaskInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.dQc = parcel.readByte() == (byte) 1;
        this.downloadUrl = parcel.readString();
        this.mediaId = parcel.readString();
        this.filePath = parcel.readString();
        this.hKj = parcel.readString();
        this.hKk = parcel.readString();
        this.hKl = parcel.readInt();
        this.hKm = parcel.readInt();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.hKn = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.hKp = z2;
    }

    public boolean equals(Object obj) {
        return obj == this || (obj != null && (obj instanceof CDNTaskInfo) && ((CDNTaskInfo) obj).downloadUrl.equals(this.downloadUrl));
    }

    public int hashCode() {
        return this.downloadUrl.hashCode();
    }

    public CDNTaskInfo(String str) {
        this.downloadUrl = str;
    }
}

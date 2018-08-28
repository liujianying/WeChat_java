package com.tencent.mm.plugin.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FileDownloadTaskInfo implements Parcelable {
    public static Creator<FileDownloadTaskInfo> CREATOR = new 1();
    public String appId;
    public String bKg;
    public int bPG;
    public long gTK;
    public long icq;
    public boolean icr;
    public boolean ics;
    public long id;
    public String path;
    public int status;
    public String url;

    /* synthetic */ FileDownloadTaskInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.url);
        parcel.writeInt(this.status);
        parcel.writeString(this.path);
        parcel.writeString(this.bKg);
        parcel.writeString(this.appId);
        parcel.writeLong(this.icq);
        parcel.writeLong(this.gTK);
        parcel.writeByte((byte) (this.icr ? 1 : 0));
        parcel.writeInt(this.bPG);
    }

    public FileDownloadTaskInfo() {
        this.id = -1;
        this.url = "";
        this.status = 0;
        this.path = "";
        this.bKg = "";
        this.appId = "";
        this.icq = 0;
        this.gTK = 0;
        this.icr = false;
        this.bPG = 2;
        this.ics = false;
    }

    private FileDownloadTaskInfo(Parcel parcel) {
        boolean z = true;
        this.id = -1;
        this.url = "";
        this.status = 0;
        this.path = "";
        this.bKg = "";
        this.appId = "";
        this.icq = 0;
        this.gTK = 0;
        this.icr = false;
        this.bPG = 2;
        this.ics = false;
        this.id = parcel.readLong();
        this.url = parcel.readString();
        this.status = parcel.readInt();
        this.path = parcel.readString();
        this.bKg = parcel.readString();
        this.appId = parcel.readString();
        this.icq = parcel.readLong();
        this.gTK = parcel.readLong();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.icr = z;
        this.bPG = parcel.readInt();
    }
}

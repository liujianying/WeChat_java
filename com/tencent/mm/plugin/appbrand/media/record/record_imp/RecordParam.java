package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.media.record.b;

public class RecordParam implements Parcelable {
    public static final Creator<RecordParam> CREATOR = new 1();
    public int aft = 0;
    public String appId = "";
    public String dfX;
    public int duration = 0;
    public String fIJ;
    public int gji = 0;
    public int gjj = 0;
    public b gjk = b.gic;
    public String processName = "";
    public int sampleRate = 0;
    public int scene = 0;

    public int describeContents() {
        return 0;
    }

    public RecordParam(Parcel parcel) {
        this.duration = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.gji = parcel.readInt();
        this.gjj = parcel.readInt();
        this.fIJ = parcel.readString();
        this.dfX = parcel.readString();
        this.scene = parcel.readInt();
        this.aft = parcel.readInt();
        this.processName = parcel.readString();
        this.appId = parcel.readString();
        this.gjk = b.values()[parcel.readInt()];
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.duration);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.gji);
        parcel.writeInt(this.gjj);
        parcel.writeString(this.fIJ);
        parcel.writeString(this.dfX);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.aft);
        parcel.writeString(this.processName);
        parcel.writeString(this.appId);
        parcel.writeInt(this.gjk.ordinal());
    }
}

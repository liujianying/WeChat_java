package com.tencent.mm.plugin.appbrand.appcache.base;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.pluginsdk.g.a.c.k;

public class WxaPkgLoadProgress extends k implements Parcelable {
    public static final Creator<WxaPkgLoadProgress> CREATOR = new 1();
    public long fix = -1;
    public long fiy = -1;
    public int progress = 0;

    public WxaPkgLoadProgress(int i, long j, long j2) {
        this.progress = i;
        this.fix = j;
        this.fiy = j2;
    }

    protected WxaPkgLoadProgress(Parcel parcel) {
        this.progress = parcel.readInt();
        this.fix = parcel.readLong();
        this.fiy = parcel.readLong();
    }

    public String toString() {
        return "WxaPkgLoadProgress{progress=" + this.progress + ", writtenLength=" + this.fix + ", totalLength=" + this.fiy + '}';
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.progress);
        parcel.writeLong(this.fix);
        parcel.writeLong(this.fiy);
    }
}

package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class AppBrandGlobalSystemConfig$PackageManager implements Parcelable {
    public static final Creator<AppBrandGlobalSystemConfig$PackageManager> CREATOR = new 1();
    public long fqj = 86400;
    public long fqk = 864000;
    public long fql = 256;
    public int fqm = 5;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.fqj);
        parcel.writeLong(this.fqk);
        parcel.writeLong(this.fql);
        parcel.writeInt(this.fqm);
    }

    protected AppBrandGlobalSystemConfig$PackageManager(Parcel parcel) {
        this.fqj = parcel.readLong();
        this.fqk = parcel.readLong();
        this.fql = parcel.readLong();
        this.fqm = parcel.readInt();
    }
}

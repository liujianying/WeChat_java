package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class AppBrandGlobalSystemConfig$WeAppSyncVersionSetting implements Parcelable {
    public static final Creator<AppBrandGlobalSystemConfig$WeAppSyncVersionSetting> CREATOR = new 1();
    public long fqn = 21600;
    public long fqo = 604800;
    public int fqp = 1000;
    public int fqq = 100;

    AppBrandGlobalSystemConfig$WeAppSyncVersionSetting() {
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.fqn);
        parcel.writeLong(this.fqo);
        parcel.writeInt(this.fqp);
        parcel.writeInt(this.fqq);
    }

    AppBrandGlobalSystemConfig$WeAppSyncVersionSetting(Parcel parcel) {
        this.fqn = parcel.readLong();
        this.fqo = parcel.readLong();
        this.fqp = parcel.readInt();
        this.fqq = parcel.readInt();
    }
}

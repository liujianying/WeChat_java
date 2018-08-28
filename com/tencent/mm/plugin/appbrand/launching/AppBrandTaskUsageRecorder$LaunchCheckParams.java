package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

final class AppBrandTaskUsageRecorder$LaunchCheckParams implements Parcelable {
    public static final Creator<AppBrandTaskUsageRecorder$LaunchCheckParams> CREATOR = new 1();
    final int fKP;
    final String fdE;
    final int fii;
    final boolean fxd = true;
    final AppBrandInitConfig gfp;
    final AppBrandStatObject gfq;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.gfp, i);
        parcel.writeParcelable(this.gfq, i);
        parcel.writeInt(this.fii);
        parcel.writeInt(this.fKP);
        parcel.writeString(this.fdE);
    }

    public AppBrandTaskUsageRecorder$LaunchCheckParams(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject, int i, int i2, String str) {
        this.gfp = appBrandInitConfig;
        this.gfq = appBrandStatObject;
        this.fii = i;
        this.fKP = i2;
        this.fdE = str;
    }

    AppBrandTaskUsageRecorder$LaunchCheckParams(Parcel parcel) {
        this.gfp = (AppBrandInitConfig) parcel.readParcelable(AppBrandInitConfig.class.getClassLoader());
        this.gfq = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
        this.fii = parcel.readInt();
        this.fKP = parcel.readInt();
        this.fdE = parcel.readString();
    }
}

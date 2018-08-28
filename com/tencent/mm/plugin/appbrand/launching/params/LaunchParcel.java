package com.tencent.mm.plugin.appbrand.launching.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class LaunchParcel implements Parcelable {
    public static final Creator<LaunchParcel> CREATOR = new Creator<LaunchParcel>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LaunchParcel(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LaunchParcel[i];
        }
    };
    public String appId;
    public int fmv;
    public AppBrandLaunchReferrer fqA;
    public String fqx;
    public AppBrandStatObject ghm;
    public LaunchParamsOptional ghn;
    public String username;
    public int version;

    /* synthetic */ LaunchParcel(Parcel parcel, byte b) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeInt(this.version);
        parcel.writeInt(this.fmv);
        parcel.writeString(this.fqx);
        parcel.writeParcelable(this.ghm, i);
        parcel.writeParcelable(this.fqA, i);
        parcel.writeParcelable(this.ghn, i);
    }

    private LaunchParcel(Parcel parcel) {
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.version = parcel.readInt();
        this.fmv = parcel.readInt();
        this.fqx = parcel.readString();
        this.ghm = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
        this.fqA = (AppBrandLaunchReferrer) parcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader());
        this.ghn = (LaunchParamsOptional) parcel.readParcelable(LaunchParamsOptional.class.getClassLoader());
    }

    public final void a(AppBrandInitConfig appBrandInitConfig) {
        String str = null;
        if (appBrandInitConfig != null) {
            appBrandInitConfig.username = this.username;
            appBrandInitConfig.fqx = a.qB(this.fqx);
            appBrandInitConfig.fqA.a(this.fqA);
            appBrandInitConfig.dFy = this.ghn == null ? null : this.ghn.dFy;
            if (this.ghn != null) {
                str = this.ghn.dzR;
            }
            appBrandInitConfig.dzR = str;
        }
    }
}

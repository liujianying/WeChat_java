package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.base.WxaPkgLoadProgress;

class RuntimeLoadModuleTask$WxaPkgResultProgressPair implements Parcelable {
    public static final Creator<RuntimeLoadModuleTask$WxaPkgResultProgressPair> CREATOR = new 1();
    WxaPkgWrappingInfo ggP;
    WxaPkgLoadProgress ggQ;
    private a ggR;

    RuntimeLoadModuleTask$WxaPkgResultProgressPair(Parcel parcel) {
        this.ggP = (WxaPkgWrappingInfo) parcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader());
        this.ggQ = (WxaPkgLoadProgress) parcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader());
        this.ggR = (a) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.ggP, i);
        parcel.writeParcelable(this.ggQ, i);
        parcel.writeSerializable(this.ggR);
    }

    RuntimeLoadModuleTask$WxaPkgResultProgressPair(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.ggP = wxaPkgWrappingInfo;
        this.ggR = a.ggS;
    }

    RuntimeLoadModuleTask$WxaPkgResultProgressPair(WxaPkgLoadProgress wxaPkgLoadProgress) {
        this.ggQ = wxaPkgLoadProgress;
        this.ggR = a.ggT;
    }
}

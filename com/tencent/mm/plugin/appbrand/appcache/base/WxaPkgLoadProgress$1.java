package com.tencent.mm.plugin.appbrand.appcache.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class WxaPkgLoadProgress$1 implements Creator<WxaPkgLoadProgress> {
    WxaPkgLoadProgress$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new WxaPkgLoadProgress(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WxaPkgLoadProgress[i];
    }
}

package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.HttpSetting;

class AppBrandGlobalSystemConfig$HttpSetting$1 implements Creator<HttpSetting> {
    AppBrandGlobalSystemConfig$HttpSetting$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new HttpSetting(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new HttpSetting[i];
    }
}

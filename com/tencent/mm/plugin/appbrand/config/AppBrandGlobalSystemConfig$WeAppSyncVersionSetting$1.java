package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.WeAppSyncVersionSetting;

class AppBrandGlobalSystemConfig$WeAppSyncVersionSetting$1 implements Creator<WeAppSyncVersionSetting> {
    AppBrandGlobalSystemConfig$WeAppSyncVersionSetting$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new WeAppSyncVersionSetting(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WeAppSyncVersionSetting[i];
    }
}

package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;

class AppBrandGlobalSystemConfig$PackageManager$1 implements Creator<PackageManager> {
    AppBrandGlobalSystemConfig$PackageManager$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PackageManager(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PackageManager[i];
    }
}

package com.tencent.mm.plugin.appbrand.task;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class AppBrandRemoteTaskController$2 implements Creator<AppBrandRemoteTaskController> {
    AppBrandRemoteTaskController$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppBrandRemoteTaskController appBrandRemoteTaskController = new AppBrandRemoteTaskController();
        appBrandRemoteTaskController.g(parcel);
        return appBrandRemoteTaskController;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AppBrandRemoteTaskController[i];
    }
}

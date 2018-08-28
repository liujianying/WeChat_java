package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper;

class ILaunchWxaAppInfoNotify$LaunchInfoIpcWrapper$1 implements Creator<LaunchInfoIpcWrapper> {
    ILaunchWxaAppInfoNotify$LaunchInfoIpcWrapper$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new LaunchInfoIpcWrapper(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LaunchInfoIpcWrapper[i];
    }
}

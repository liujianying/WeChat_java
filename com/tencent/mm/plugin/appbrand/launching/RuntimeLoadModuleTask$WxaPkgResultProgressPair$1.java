package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.WxaPkgResultProgressPair;

class RuntimeLoadModuleTask$WxaPkgResultProgressPair$1 implements Creator<WxaPkgResultProgressPair> {
    RuntimeLoadModuleTask$WxaPkgResultProgressPair$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new WxaPkgResultProgressPair(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WxaPkgResultProgressPair[i];
    }
}

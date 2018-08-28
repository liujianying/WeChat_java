package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class IPCAudioParamRequest$1 implements Creator<IPCAudioParamRequest> {
    IPCAudioParamRequest$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new IPCAudioParamRequest(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new IPCAudioParamRequest[i];
    }
}

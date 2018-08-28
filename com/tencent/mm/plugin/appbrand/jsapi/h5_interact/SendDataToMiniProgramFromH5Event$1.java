package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class SendDataToMiniProgramFromH5Event$1 implements Creator<SendDataToMiniProgramFromH5Event> {
    SendDataToMiniProgramFromH5Event$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SendDataToMiniProgramFromH5Event(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SendDataToMiniProgramFromH5Event[i];
    }
}

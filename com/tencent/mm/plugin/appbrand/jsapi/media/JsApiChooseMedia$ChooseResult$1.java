package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.ChooseResult;

class JsApiChooseMedia$ChooseResult$1 implements Creator<ChooseResult> {
    JsApiChooseMedia$ChooseResult$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ChooseResult(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ChooseResult[i];
    }
}

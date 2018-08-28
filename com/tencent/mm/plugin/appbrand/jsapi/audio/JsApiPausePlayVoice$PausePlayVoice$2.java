package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice.PausePlayVoice;

class JsApiPausePlayVoice$PausePlayVoice$2 implements Creator<PausePlayVoice> {
    JsApiPausePlayVoice$PausePlayVoice$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        PausePlayVoice pausePlayVoice = new PausePlayVoice((byte) 0);
        pausePlayVoice.g(parcel);
        return pausePlayVoice;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PausePlayVoice[i];
    }
}

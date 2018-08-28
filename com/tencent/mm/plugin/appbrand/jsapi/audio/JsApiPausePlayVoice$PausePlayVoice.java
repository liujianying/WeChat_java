package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ah;

class JsApiPausePlayVoice$PausePlayVoice extends MainProcessTask {
    public static final Creator<JsApiPausePlayVoice$PausePlayVoice> CREATOR = new 2();

    private JsApiPausePlayVoice$PausePlayVoice() {
    }

    /* synthetic */ JsApiPausePlayVoice$PausePlayVoice(byte b) {
        this();
    }

    public final void aai() {
        ah.A(new 1(this));
    }
}

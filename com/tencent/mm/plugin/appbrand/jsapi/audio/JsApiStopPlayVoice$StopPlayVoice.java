package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ah;

class JsApiStopPlayVoice$StopPlayVoice extends MainProcessTask {
    public static final Creator<JsApiStopPlayVoice$StopPlayVoice> CREATOR = new 2();

    private JsApiStopPlayVoice$StopPlayVoice() {
    }

    /* synthetic */ JsApiStopPlayVoice$StopPlayVoice(byte b) {
        this();
    }

    public final void aai() {
        ah.A(new 1(this));
    }
}

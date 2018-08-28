package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.StartRecordVoice;
import com.tencent.mm.plugin.appbrand.media.record.a;

class JsApiStartRecordVoice$StartRecordVoice$1 implements Runnable {
    final /* synthetic */ StartRecordVoice fJh;

    JsApiStartRecordVoice$StartRecordVoice$1(StartRecordVoice startRecordVoice) {
        this.fJh = startRecordVoice;
    }

    public final void run() {
        StartRecordVoice.a(this.fJh, a.a(StartRecordVoice.a(this.fJh), new 1(this), StartRecordVoice.c(this.fJh) * 1000));
        if (!StartRecordVoice.d(this.fJh)) {
            StartRecordVoice.e(this.fJh);
        }
    }
}

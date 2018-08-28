package com.tencent.mm.plugin.appbrand.jsapi.audio;

class JsApiStartRecordVoice$3 implements Runnable {
    final /* synthetic */ boolean fIG;
    final /* synthetic */ JsApiStartRecordVoice fJe;

    JsApiStartRecordVoice$3(JsApiStartRecordVoice jsApiStartRecordVoice, boolean z) {
        this.fJe = jsApiStartRecordVoice;
        this.fIG = z;
    }

    public final void run() {
        JsApiStartRecordVoice.a(this.fJe, this.fIG);
    }
}

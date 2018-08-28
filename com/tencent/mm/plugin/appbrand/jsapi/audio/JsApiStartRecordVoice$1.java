package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p.d;

class JsApiStartRecordVoice$1 implements d {
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiStartRecordVoice fJe;

    JsApiStartRecordVoice$1(JsApiStartRecordVoice jsApiStartRecordVoice, l lVar) {
        this.fJe = jsApiStartRecordVoice;
        this.fCl = lVar;
    }

    public final void agK() {
        JsApiStopRecordVoice.h(this.fCl);
        JsApiStartRecordVoice.a(this.fJe).b(this);
    }
}

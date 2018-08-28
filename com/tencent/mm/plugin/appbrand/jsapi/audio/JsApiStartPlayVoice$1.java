package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p$d;

class JsApiStartPlayVoice$1 implements p$d {
    final /* synthetic */ p fIY;
    final /* synthetic */ JsApiStartPlayVoice fIZ;

    JsApiStartPlayVoice$1(JsApiStartPlayVoice jsApiStartPlayVoice, p pVar) {
        this.fIZ = jsApiStartPlayVoice;
        this.fIY = pVar;
    }

    public final void agK() {
        JsApiStopPlayVoice.ahZ();
        this.fIY.b(this);
    }
}

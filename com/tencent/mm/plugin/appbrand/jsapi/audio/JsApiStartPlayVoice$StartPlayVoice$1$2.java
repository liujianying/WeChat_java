package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.ab.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice.StartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice.StartPlayVoice.1;

class JsApiStartPlayVoice$StartPlayVoice$1$2 implements b {
    final /* synthetic */ 1 fJb;

    JsApiStartPlayVoice$StartPlayVoice$1$2(1 1) {
        this.fJb = 1;
    }

    public final void onError() {
        this.fJb.fJa.fHX = true;
        StartPlayVoice.c(this.fJb.fJa);
    }
}

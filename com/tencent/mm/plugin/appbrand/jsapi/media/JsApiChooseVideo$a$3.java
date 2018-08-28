package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.a;

class JsApiChooseVideo$a$3 implements Runnable {
    final /* synthetic */ a fUU;
    final /* synthetic */ String fUV;

    JsApiChooseVideo$a$3(a aVar, String str) {
        this.fUU = aVar;
        this.fUV = str;
    }

    public final void run() {
        a.a(this.fUU).bjW = -1;
        a.a(this.fUU).fUR = a.a(this.fUU, this.fUV, a.c(this.fUU).fUQ);
        a.d(this.fUU, a.a(this.fUU));
    }
}

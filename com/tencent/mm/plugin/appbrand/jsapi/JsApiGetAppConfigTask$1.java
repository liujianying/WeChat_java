package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.config.m.c;

class JsApiGetAppConfigTask$1 implements c {
    final /* synthetic */ JsApiGetAppConfigTask fFP;

    JsApiGetAppConfigTask$1(JsApiGetAppConfigTask jsApiGetAppConfigTask) {
        this.fFP = jsApiGetAppConfigTask;
    }

    public final void qR(String str) {
        this.fFP.value = str;
        JsApiGetAppConfigTask.a(this.fFP);
    }
}

package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1.1;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.aoh;

class JsApiLaunchApplication$1$1$2 implements Runnable {
    final /* synthetic */ 1 fGa;
    final /* synthetic */ aoh fGb;
    final /* synthetic */ a fGc;
    final /* synthetic */ Intent val$intent;

    JsApiLaunchApplication$1$1$2(1 1, Intent intent, aoh aoh, a aVar) {
        this.fGa = 1;
        this.val$intent = intent;
        this.fGb = aoh;
        this.fGc = aVar;
    }

    public final void run() {
        this.fGc.cJ(g.a(this.fGa.fFZ.fCl.getContext(), this.val$intent, null, this.fGb.rQQ, this.fGc, this.fGa.fFZ.fFU));
    }
}

package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.g.a.qy;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall.StartVoIPCall;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class JsApiMakeVoIPCall$StartVoIPCall$1 extends c<qy> {
    final /* synthetic */ StartVoIPCall fGm;

    JsApiMakeVoIPCall$StartVoIPCall$1(StartVoIPCall startVoIPCall) {
        this.fGm = startVoIPCall;
        this.sFo = qy.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qy qyVar = (qy) bVar;
        if (qyVar != null && (qyVar instanceof qy)) {
            this.fGm.status = qyVar.cbK.status;
            a.sFg.c(StartVoIPCall.a(this.fGm));
            StartVoIPCall.b(this.fGm);
        }
        return false;
    }
}

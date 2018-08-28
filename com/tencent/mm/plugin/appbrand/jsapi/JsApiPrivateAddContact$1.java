package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.sdk.platformtools.x;

class JsApiPrivateAddContact$1 implements b<JsApiPrivateAddContact$AddContactResult> {
    final /* synthetic */ int doP;
    final /* synthetic */ c fGB;
    final /* synthetic */ JsApiPrivateAddContact fGC;

    JsApiPrivateAddContact$1(JsApiPrivateAddContact jsApiPrivateAddContact, c cVar, int i) {
        this.fGC = jsApiPrivateAddContact;
        this.fGB = cVar;
        this.doP = i;
    }

    public final /* synthetic */ void c(AppBrandProxyUIProcessTask$ProcessResult appBrandProxyUIProcessTask$ProcessResult) {
        x.i("MicroMsg.JsApiPrivateAddContact", "onReceiveResult resultCode:%d", new Object[]{Integer.valueOf(((JsApiPrivateAddContact$AddContactResult) appBrandProxyUIProcessTask$ProcessResult).bjW)});
        switch (((JsApiPrivateAddContact$AddContactResult) appBrandProxyUIProcessTask$ProcessResult).bjW) {
            case -2:
                this.fGB.E(this.doP, this.fGC.f("added", null));
                return;
            case -1:
                this.fGB.E(this.doP, this.fGC.f("fail", null));
                return;
            case 0:
                this.fGB.E(this.doP, this.fGC.f("cancel", null));
                return;
            case 1:
                this.fGB.E(this.doP, this.fGC.f("ok", null));
                return;
            default:
                return;
        }
    }
}

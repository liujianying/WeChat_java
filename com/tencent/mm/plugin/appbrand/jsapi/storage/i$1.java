package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.l;

class i$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiSetStorageTask fZw;
    final /* synthetic */ i fZx;

    i$1(i iVar, l lVar, int i, JsApiSetStorageTask jsApiSetStorageTask) {
        this.fZx = iVar;
        this.fCl = lVar;
        this.doP = i;
        this.fZw = jsApiSetStorageTask;
    }

    public final void run() {
        this.fCl.E(this.doP, this.fZx.f(this.fZw.result, null));
        this.fZw.ahB();
    }
}

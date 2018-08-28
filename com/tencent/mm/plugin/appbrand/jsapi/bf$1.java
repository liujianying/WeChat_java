package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;

class bf$1 extends b {
    final /* synthetic */ l fCl;
    final /* synthetic */ bf fHe;

    bf$1(bf bfVar, l lVar) {
        this.fHe = bfVar;
        this.fCl = lVar;
    }

    public final void onDestroy() {
        x.i("MicroMsg.JsApiSetKeepScreenOn", "onDestroy");
        if (bf.a(this.fHe)) {
            bf.b(this.fHe);
        }
        e.b(this.fCl.mAppId, this);
    }

    public final void a(c cVar) {
        x.i("MicroMsg.JsApiSetKeepScreenOn", "onPause");
        if (bf.a(this.fHe)) {
            bf.b(this.fHe);
        }
    }

    public final void onResume() {
        x.i("MicroMsg.JsApiSetKeepScreenOn", "onResume");
        if (bf.access$200()) {
            bf.c(this.fHe);
        }
    }
}

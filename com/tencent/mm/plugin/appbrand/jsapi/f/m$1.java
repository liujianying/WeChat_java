package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.m;
import com.tencent.mm.sdk.platformtools.x;

class m$1 implements m {
    final /* synthetic */ f fPe;
    final /* synthetic */ m fSM;

    m$1(m mVar, f fVar) {
        this.fSM = mVar;
        this.fPe = fVar;
    }

    public final void cR(boolean z) {
        x.i("MicroMsg.JsApiTranslateMapMarker", "onMarkerTranslate result::%b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.fPe.tp(this.fSM.f("ok", null));
            m.a(this.fSM).aqm();
            return;
        }
        this.fPe.tp(this.fSM.f("fail", null));
    }
}

package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.g.f;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.report.service.h;

final class l$a extends c {
    final /* synthetic */ l fAv;

    l$a(l lVar, d dVar, f fVar) {
        this.fAv = lVar;
        super(dVar, fVar);
    }

    protected final void aad() {
        super.aad();
    }

    protected final a aae() {
        a aae = super.aae();
        if (!this.fAv.agn()) {
            aae.addJavascriptInterface(new d(this.fAv.fAr, aae), "WeixinJSCore");
            aae.evaluateJavascript(com.tencent.mm.plugin.appbrand.q.c.vM("wxa_library/android.js"), null);
        }
        return aae;
    }

    protected final String aaf() {
        return WxaCommLibRuntimeReader.qJ("WAGameSubContext.js");
    }

    protected final void aag() {
    }

    protected final void cq(boolean z) {
        h.mEJ.a(778, 17, 1, false);
        if (z) {
            h.mEJ.a(778, 19, 1, false);
            return;
        }
        h.mEJ.a(778, 18, 1, false);
        com.tencent.mm.plugin.appbrand.report.a.G(this.fAv.fAr.fdO.mAppId, 24, 0);
        com.tencent.mm.plugin.appbrand.report.a.a(this.fAv.fAr.mAppId, this.fAv.fAr.fdO.fcu.frm.fii, this.fAv.fAr.fdO.fcu.frm.fih, 778, 18);
    }

    protected final void aah() {
    }

    protected final void cr(boolean z) {
        h.mEJ.a(778, 21, 1, false);
        if (z) {
            h.mEJ.a(778, 23, 1, false);
            return;
        }
        h.mEJ.a(778, 22, 1, false);
        com.tencent.mm.plugin.appbrand.report.a.G(this.fAv.fAr.mAppId, 24, 0);
        com.tencent.mm.plugin.appbrand.report.a.a(this.fAv.fAr.mAppId, this.fAv.fAr.fdO.fcu.frm.fii, this.fAv.fAr.fdO.fcu.frm.fih, 778, 22);
    }
}

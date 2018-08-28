package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class a$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ a fPd;

    a$1(a aVar, l lVar, int i, JSONObject jSONObject) {
        this.fPd = aVar;
        this.fCl = lVar;
        this.doP = i;
        this.fHi = jSONObject;
    }

    public final void run() {
        p d = a.d(this.fCl);
        if (d == null) {
            x.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
            this.fCl.E(this.doP, this.fPd.f("fail", null));
        } else if (d.fdO.aaq()) {
            a a = a.a(d, this.fHi, false);
            this.fCl.E(this.doP, this.fPd.f(a.Yy, a.values));
        } else {
            a.a(this.fPd, this.fCl, this.fHi, this.doP);
        }
    }
}

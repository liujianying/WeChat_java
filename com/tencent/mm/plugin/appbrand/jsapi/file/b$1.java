package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.m;
import org.json.JSONObject;

class b$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ b fQb;

    b$1(b bVar, l lVar, JSONObject jSONObject, int i) {
        this.fQb = bVar;
        this.fCl = lVar;
        this.fHi = jSONObject;
        this.doP = i;
    }

    public final void run() {
        f$a b = b.a(this.fQb).b(this.fCl, this.fHi);
        m.a(this.fCl, b.values, this.fQb);
        this.fCl.E(this.doP, this.fQb.f(b.Yy, b.values));
    }
}

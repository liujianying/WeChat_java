package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

class a$1 implements Runnable {
    final /* synthetic */ l fCl;
    final /* synthetic */ String fEg;
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ a fVZ;

    a$1(a aVar, l lVar, JSONObject jSONObject, String str) {
        this.fVZ = aVar;
        this.fCl = lVar;
        this.fHi = jSONObject;
        this.fEg = str;
    }

    public final void run() {
        this.fVZ.a(this.fCl, this.fHi, this.fEg);
    }
}

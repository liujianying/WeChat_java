package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.permission.c.a;
import com.tencent.mm.plugin.appbrand.permission.c.b;

class d$3 implements b {
    final /* synthetic */ int doP;
    final /* synthetic */ d fEP;
    final /* synthetic */ String fES;
    final /* synthetic */ String fET;
    final /* synthetic */ boolean fEU;
    final /* synthetic */ e fEV;

    d$3(d dVar, String str, String str2, int i, boolean z, e eVar) {
        this.fEP = dVar;
        this.fES = str;
        this.fET = str2;
        this.doP = i;
        this.fEU = z;
        this.fEV = eVar;
    }

    public final void a(a aVar) {
        if (this.fEP.fEJ != null && this.fEP.fEJ.isRunning()) {
            if (aVar.code == 1) {
                this.fEP.fwr.post(new 1(this));
            } else {
                this.fEP.fEJ.E(this.doP, this.fEV.f(aVar.bIr, null));
            }
        }
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.widget.c.b;
import com.tencent.mm.sdk.platformtools.bi;

class c$1 implements Runnable {
    final /* synthetic */ String dEt;
    final /* synthetic */ int doP;
    final /* synthetic */ String efo;
    final /* synthetic */ l fCl;
    final /* synthetic */ String fXI;
    final /* synthetic */ Boolean fXJ;
    final /* synthetic */ String fXK;
    final /* synthetic */ int fXL;
    final /* synthetic */ int fXM;
    final /* synthetic */ c fXN;

    c$1(c cVar, l lVar, String str, String str2, String str3, int i, Boolean bool, String str4, int i2, int i3) {
        this.fXN = cVar;
        this.fCl = lVar;
        this.dEt = str;
        this.efo = str2;
        this.fXI = str3;
        this.doP = i;
        this.fXJ = bool;
        this.fXK = str4;
        this.fXL = i2;
        this.fXM = i3;
    }

    public final void run() {
        if (this.fCl.Sx) {
            b bVar = new b(c.c(this.fCl));
            if (!bi.oW(this.dEt)) {
                bVar.setTitle(this.dEt);
            }
            bVar.setMessage(this.efo);
            bVar.a(this.fXI, true, new 1(this));
            if (this.fXJ.booleanValue()) {
                bVar.b(this.fXK, false, new 2(this));
            }
            bVar.setOnCancelListener(new 3(this));
            bVar.Go(this.fXL);
            if (this.fXJ.booleanValue()) {
                bVar.Gp(this.fXM);
            }
            this.fCl.fdO.a(bVar);
        }
    }
}

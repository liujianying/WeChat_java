package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.d.1;
import com.tencent.mm.plugin.appbrand.r.b.b.a;

class c$8 implements Runnable {
    final /* synthetic */ double dSw;
    final /* synthetic */ double dSx;
    final /* synthetic */ double dSz;
    final /* synthetic */ c fTi;
    final /* synthetic */ a fTo;

    c$8(c cVar, double d, double d2, a aVar, double d3) {
        this.fTi = cVar;
        this.dSw = d;
        this.dSx = d2;
        this.fTo = aVar;
        this.dSz = d3;
    }

    public final void run() {
        if (this.fTi.fSW == null) {
            return;
        }
        double d;
        if (this.fTi.fSY == null) {
            this.fTi.fSY = new d(this.fTi.context);
            d dVar = this.fTi.fSY;
            b bVar = this.fTi.fSW;
            double d2 = this.dSw;
            d = this.dSx;
            i ady = bVar.ady();
            ady.A(0.5f, 0.5f);
            ady.h(d2, d);
            ady.bF(dVar);
            dVar.fTv = bVar.a(ady);
            return;
        }
        d dVar2 = this.fTi.fSY;
        double d3 = this.dSw;
        d = this.dSx;
        a aVar = this.fTo;
        double d4 = this.dSz;
        if (dVar2.fTR == -1.0d && dVar2.fTS == -1.0d) {
            dVar2.fTR = d3;
            dVar2.fTP = d3;
            dVar2.fTS = d;
            dVar2.fTQ = d;
        } else {
            dVar2.fTR = dVar2.fTP;
            dVar2.fTS = dVar2.fTQ;
            dVar2.fTQ = d;
            dVar2.fTP = d3;
        }
        if (!(dVar2.fTR == -1.0d || dVar2.fTS == -1.0d)) {
            dVar2.fTW = e.a(dVar2.fTS, dVar2.fTR, d, d3, aVar, d4);
        }
        if (dVar2.fTU == 900.0f || dVar2.fTT == 900.0f) {
            float i = (float) e.i(d3, d);
            dVar2.fTT = i;
            dVar2.fTU = i;
        } else {
            dVar2.fTU = dVar2.fTT;
            dVar2.fTT = (float) e.i(d3, d);
        }
        if (dVar2.fTv != null) {
            dVar2.fTv.b(new 1(dVar2, d3, d));
        }
    }
}

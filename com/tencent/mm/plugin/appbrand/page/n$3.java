package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.page.p.g;
import com.tencent.mm.plugin.appbrand.report.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class n$3 implements g {
    final /* synthetic */ long cXh;
    final /* synthetic */ n gmP;
    final /* synthetic */ l gmR;
    final /* synthetic */ aa gmS;
    final /* synthetic */ Runnable gmT;

    n$3(n nVar, l lVar, Runnable runnable, long j, aa aaVar) {
        this.gmP = nVar;
        this.gmR = lVar;
        this.gmT = runnable;
        this.cXh = j;
        this.gmS = aaVar;
    }

    public final void onReady() {
        int i;
        int i2 = 2;
        this.gmR.getCurrentPageView().b(this);
        this.gmP.removeCallbacks(this.gmT);
        this.gmP.post(this.gmT);
        this.gmP.alM();
        long currentTimeMillis = System.currentTimeMillis() - this.cXh;
        b b = n.b(this.gmP);
        switch (b$3.grd[this.gmS.ordinal()]) {
            case 1:
                i = 1;
                break;
            case 2:
            case 3:
            case 4:
                i = 3;
                break;
            default:
                i = 2;
                break;
        }
        b.h(currentTimeMillis, i);
        h.mEJ.a(390, 0, 1, false);
        switch (((int) currentTimeMillis) / 250) {
            case 0:
                i2 = 1;
                break;
            case 1:
                break;
            case 2:
                i2 = 3;
                break;
            case 3:
                i2 = 4;
                break;
            case 4:
            case 5:
                i2 = 5;
                break;
            case 6:
            case 7:
                i2 = 6;
                break;
            default:
                i2 = 7;
                break;
        }
        h.mEJ.a(390, (long) i2, 1, false);
        x.i("MicroMsg.AppBrandPageContainer", "onReady received, time: %d", new Object[]{Long.valueOf(currentTimeMillis)});
    }
}

package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.report.a.b;
import com.tencent.mm.sdk.platformtools.x;

class n$2 implements Runnable {
    final /* synthetic */ n gmP;
    final /* synthetic */ boolean[] gmQ;
    final /* synthetic */ l gmR;
    final /* synthetic */ aa gmS;

    n$2(n nVar, boolean[] zArr, aa aaVar, l lVar) {
        this.gmP = nVar;
        this.gmQ = zArr;
        this.gmS = aaVar;
        this.gmR = lVar;
    }

    public final void run() {
        p pVar = null;
        x.i("MicroMsg.AppBrandPageContainer", "hy: test navigateTask run");
        if (!this.gmQ[0]) {
            this.gmQ[0] = true;
            if (this.gmP.getPageCount() != 0) {
                l lVar;
                if (n.a(this.gmP).isEmpty()) {
                    lVar = null;
                } else {
                    lVar = (l) n.a(this.gmP).getFirst();
                }
                if (this.gmS == aa.gpl || this.gmS == aa.gpj || this.gmS == aa.gpk) {
                    n.a(this.gmP, lVar);
                }
                boolean b = n.b(this.gmS);
                n.a(this.gmP, lVar, b, n.c(this.gmS));
                n.a(this.gmP, this.gmR, b);
                b b2 = n.b(this.gmP);
                p currentPageView = this.gmR.getCurrentPageView();
                if (lVar != null) {
                    pVar = lVar.getCurrentPageView();
                }
                b2.a(currentPageView, pVar, this.gmS);
            }
        }
    }
}

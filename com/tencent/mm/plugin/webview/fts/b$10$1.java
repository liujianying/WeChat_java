package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.fts.b.10;
import com.tencent.mm.sdk.platformtools.x;

class b$10$1 implements Runnable {
    final /* synthetic */ 10 pOk;

    b$10$1(10 10) {
        this.pOk = 10;
    }

    public final void run() {
        if (b.c(this.pOk.pOa) != 4 && b.c(this.pOk.pOa) != 2 && b.c(this.pOk.pOa) != 3) {
            x.e("FTSSearchWidgetMgr", "widget load timeout, unbind now");
            h.mEJ.a(867, 5, 1, false);
            s.i("FTSSearchWidgetMgr", "widget load timeout, unbind now", new Object[0]);
            b.bTF();
            s.z(this.pOk.bAj, false);
            this.pOk.pOf.cAH();
            this.pOk.pOf.setVisibility(4);
            b.a(this.pOk.pOa).cI(this.pOk.pOh, 3);
            b.d(this.pOk.pOa).bB(this.pOk.val$view);
            b.d(this.pOk.pOa).a(this.pOk.fwt, this.pOk.val$view);
            this.pOk.pOj.removeView(this.pOk.val$view);
            h.mEJ.h(14452, new Object[]{this.pOk.fWx.optString("searchId") + "-" + this.pOk.bAj, Integer.valueOf(12), Long.valueOf(System.currentTimeMillis())});
            h.mEJ.a(646, 0, 1, false);
        }
    }
}

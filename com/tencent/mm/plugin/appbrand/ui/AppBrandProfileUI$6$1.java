package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.6;

class AppBrandProfileUI$6$1 implements Runnable {
    final /* synthetic */ t gvn;
    final /* synthetic */ long gvq;
    final /* synthetic */ 6 gvr;

    AppBrandProfileUI$6$1(6 6, t tVar, long j) {
        this.gvr = 6;
        this.gvn = tVar;
        this.gvq = j;
    }

    public final void run() {
        AppBrandProfileUI.a(this.gvr.gvm, this.gvn, this.gvq);
        if (this.gvr.gvp && !this.gvr.gvm.isFinishing() && !this.gvr.gvm.tlP) {
            q.aei().a(this.gvr.gvm, c.Em().lnJ.getLooper());
        }
    }
}

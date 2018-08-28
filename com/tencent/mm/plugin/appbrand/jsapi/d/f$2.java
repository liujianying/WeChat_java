package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.c.e;

class f$2 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ p fJO;
    final /* synthetic */ String fQK;
    final /* synthetic */ int fQN;
    final /* synthetic */ int fQO;
    final /* synthetic */ f fQP;
    final /* synthetic */ e fQQ;

    f$2(f fVar, p pVar, int i, int i2, String str, e eVar, int i3) {
        this.fQP = fVar;
        this.fJO = pVar;
        this.fQN = i;
        this.fQO = i2;
        this.fQK = str;
        this.fQQ = eVar;
        this.doP = i3;
    }

    public final void run() {
        f.a(this.fQP, this.fJO, this.fQN, this.fQO, this.fQK, this.fQQ, this.doP);
    }
}

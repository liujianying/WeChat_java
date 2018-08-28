package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.m;

class f$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ p fJO;
    final /* synthetic */ int fQL;
    final /* synthetic */ int fQN;
    final /* synthetic */ int fQO;
    final /* synthetic */ f fQP;

    f$1(f fVar, p pVar, int i, int i2, int i3, int i4) {
        this.fQP = fVar;
        this.fJO = pVar;
        this.fQL = i;
        this.fQN = i2;
        this.fQO = i3;
        this.doP = i4;
    }

    public final void run() {
        if (m.a(this.fJO, this.fQL, this.fQN, this.fQO)) {
            this.fJO.E(this.doP, this.fQP.f("ok", null));
        } else {
            this.fJO.E(this.doP, this.fQP.f("fail:invalid data", null));
        }
    }
}

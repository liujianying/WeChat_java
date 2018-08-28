package com.tencent.mm.an;

import com.tencent.mm.g.a.js;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.b.a;

class b$5 implements Runnable {
    final /* synthetic */ avq eba;

    b$5(avq avq) {
        this.eba = avq;
    }

    public final void run() {
        js jsVar = new js();
        jsVar.bTw.action = 6;
        jsVar.bTw.bTy = this.eba;
        a.sFg.m(jsVar);
    }
}

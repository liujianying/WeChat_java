package com.tencent.mm.an;

import com.tencent.mm.g.a.js;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.b.a;

class b$8 implements Runnable {
    final /* synthetic */ avq ebb;

    b$8(avq avq) {
        this.ebb = avq;
    }

    public final void run() {
        js jsVar = new js();
        jsVar.bTw.action = 3;
        jsVar.bTw.bTy = this.ebb;
        a.sFg.m(jsVar);
    }
}

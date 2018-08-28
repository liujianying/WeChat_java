package com.tencent.mm.an;

import com.tencent.mm.g.a.js;
import com.tencent.mm.sdk.b.a;
import java.util.List;

class b$9 implements Runnable {
    final /* synthetic */ List ebe;
    final /* synthetic */ boolean ebf = true;

    public b$9(List list) {
        this.ebe = list;
    }

    public final void run() {
        js jsVar = new js();
        jsVar.bTw.action = 5;
        jsVar.bTw.bPa = this.ebe;
        jsVar.bTw.bTA = this.ebf;
        a.sFg.m(jsVar);
    }
}

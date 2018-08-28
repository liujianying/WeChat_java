package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.ui.MMActivity;

class c$3 implements Runnable {
    final /* synthetic */ c fKg;

    c$3(c cVar) {
        this.fKg = cVar;
    }

    public final void run() {
        ((MMActivity) this.fKg.fJQ.mContext).showVKB();
    }
}

package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.plugin.report.f;
import com.tencent.mm.storage.bd;

class ah$12 implements Runnable {
    final /* synthetic */ bd dAB;
    final /* synthetic */ ah tSj;

    ah$12(ah ahVar, bd bdVar) {
        this.tSj = ahVar;
        this.dAB = bdVar;
    }

    public final void run() {
        f.mDy.a(403, 6, 1, false);
        this.tSj.bb(this.dAB);
    }
}

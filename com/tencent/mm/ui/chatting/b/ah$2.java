package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.plugin.report.f;
import com.tencent.mm.storage.bd;

class ah$2 implements Runnable {
    final /* synthetic */ ah tSj;
    final /* synthetic */ bd tSn;

    ah$2(ah ahVar, bd bdVar) {
        this.tSj = ahVar;
        this.tSn = bdVar;
    }

    public final void run() {
        f.mDy.a(403, 7, 1, false);
        this.tSj.bb(this.tSn);
    }
}

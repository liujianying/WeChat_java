package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.mm.plugin.report.service.h;

class a$1 implements Runnable {
    final /* synthetic */ boolean iIq;
    final /* synthetic */ a iIr;

    a$1(a aVar, boolean z) {
        this.iIr = aVar;
        this.iIq = z;
    }

    public final void run() {
        h.mEJ.e(869, this.iIq ? 13 : 12, 1);
    }
}

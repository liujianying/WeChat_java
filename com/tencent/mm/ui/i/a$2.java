package com.tencent.mm.ui.i;

import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import org.b.b.a;

class a$2 implements Runnable {
    final /* synthetic */ a uFi;

    a$2(a aVar) {
        this.uFi = aVar;
    }

    public final void run() {
        Object b;
        try {
            this.uFi.uFd = this.uFi.uFb.cKB();
            b = this.uFi.uFb.b(this.uFi.uFd);
        } catch (a e) {
            b = null;
        }
        this.uFi.nLo.sendMessage(this.uFi.nLo.obtainMessage(BaseReportManager.MAX_READ_COUNT, b));
    }
}

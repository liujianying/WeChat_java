package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.f.2;
import com.tencent.mm.sdk.platformtools.x;

class f$2$1 implements Runnable {
    final /* synthetic */ 2 eqK;

    f$2$1(2 2) {
        this.eqK = 2;
    }

    public final void run() {
        x.i("MicroMsg.SceneVoiceInputAddr", "run NetSceneNewVoiceInput mWroteBytesCnt %s time %s", new Object[]{Integer.valueOf(f.f(this.eqK.eqI)), Long.valueOf(System.currentTimeMillis())});
        if (f.g(this.eqK.eqI) || f.i(this.eqK.eqI) == null || f.f(this.eqK.eqI) == 0) {
            x.w("MicroMsg.SceneVoiceInputAddr", "WorkerThread too busy can not do work");
            return;
        }
        g.DF().a(235, this.eqK.eqI);
        if (!((b) f.i(this.eqK.eqI)).TV() || !g.DF().a(f.i(this.eqK.eqI), 0)) {
            this.eqK.eqI.bs(13, 131);
        }
    }
}

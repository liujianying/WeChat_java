package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.model.au;

class c$1 implements Runnable {
    final /* synthetic */ c mWI;

    c$1(c cVar) {
        this.mWI = cVar;
    }

    public final void run() {
        if (!(this.mWI.mWG == null || this.mWI.mWH == null)) {
            this.mWI.mWG.removeCallbacks(this.mWI.mWH);
        }
        if (this.mWI.mWE != null) {
            au.DF().c(this.mWI.mWE);
        }
        if (!(this.mWI.mWD == null || this.mWI.mWD.cdy == null)) {
            this.mWI.mWE = new a(this.mWI.mWD.cdy);
        }
        if (this.mWI.mWE != null) {
            au.DF().a(this.mWI.mWE, 0);
        }
    }
}

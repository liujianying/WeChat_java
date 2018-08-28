package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.storage.bd;

class ak$2 implements Runnable {
    final /* synthetic */ ak tSU;

    ak$2(ak akVar) {
        this.tSU = akVar;
    }

    public final void run() {
        bd cwf = this.tSU.cwf();
        if (cwf != null) {
            this.tSU.e(cwf, false);
        }
    }
}

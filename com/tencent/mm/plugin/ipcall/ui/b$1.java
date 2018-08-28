package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.ah;

class b$1 implements Runnable {
    final /* synthetic */ b ktn;

    b$1(b bVar) {
        this.ktn = bVar;
    }

    public final void run() {
        if (System.currentTimeMillis() - this.ktn.ktg >= 500) {
            this.ktn.kte = a.av(this.ktn.bGc, this.ktn.ktc + this.ktn.ktd);
            ah.A(new 1(this, i.aXv().EP(this.ktn.kte)));
            return;
        }
        ah.A(new 2(this));
    }
}

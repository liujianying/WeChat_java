package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.b.b;

class a$1 implements Runnable {
    final /* synthetic */ a gWp;

    a$1(a aVar) {
        this.gWp = aVar;
    }

    public final void run() {
        if (this.gWp.gUv != null) {
            this.gWp.gUv.cancel();
        }
        this.gWp.gUv = new b();
        this.gWp.gUv.a(this.gWp);
    }
}

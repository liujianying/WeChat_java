package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.plugin.fts.a.l;

class h$1 implements Runnable {
    final /* synthetic */ h jsl;

    h$1(h hVar) {
        this.jsl = hVar;
    }

    public final void run() {
        l lVar = (l) h.a(this.jsl).get();
        if (lVar != null) {
            lVar.b(h.b(this.jsl));
        }
    }
}

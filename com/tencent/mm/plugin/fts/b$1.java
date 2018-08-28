package com.tencent.mm.plugin.fts;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;

class b$1 implements Runnable {
    final /* synthetic */ j joJ;
    final /* synthetic */ b joK;

    b$1(b bVar, j jVar) {
        this.joK = bVar;
        this.joJ = jVar;
    }

    public final void run() {
        l lVar = (l) b.a(this.joK).get();
        if (lVar != null) {
            lVar.b(this.joJ);
        }
    }
}

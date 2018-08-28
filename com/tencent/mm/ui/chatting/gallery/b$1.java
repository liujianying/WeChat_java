package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.storage.bd;

class b$1 implements Runnable {
    final /* synthetic */ bd dAs;
    final /* synthetic */ String fYI;
    final /* synthetic */ j tTK;
    final /* synthetic */ b tTL;

    b$1(b bVar, bd bdVar, j jVar, String str) {
        this.tTL = bVar;
        this.dAs = bdVar;
        this.tTK = jVar;
        this.fYI = str;
    }

    public final void run() {
        l.a(this.dAs, new 1(this));
    }
}

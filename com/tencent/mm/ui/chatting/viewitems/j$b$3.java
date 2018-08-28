package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.viewitems.j.b;

class j$b$3 implements Runnable {
    final /* synthetic */ bd dAB;
    final /* synthetic */ b ubo;

    j$b$3(b bVar, bd bdVar) {
        this.ubo = bVar;
        this.dAB = bdVar;
    }

    public final void run() {
        l.a(this.dAB, null);
    }
}

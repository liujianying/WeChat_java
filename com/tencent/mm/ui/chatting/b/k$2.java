package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.modelstat.a;
import com.tencent.mm.storage.bd;

class k$2 implements Runnable {
    final /* synthetic */ bd dAs;
    final /* synthetic */ k tPo;

    k$2(k kVar, bd bdVar) {
        this.tPo = kVar;
        this.dAs = bdVar;
    }

    public final void run() {
        a.a(this.dAs, a.a.ehH);
    }
}

package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.storage.bd;

class k$3 implements Runnable {
    final /* synthetic */ bd dAs;
    final /* synthetic */ k tPo;

    k$3(k kVar, bd bdVar) {
        this.tPo = kVar;
        this.dAs = bdVar;
    }

    public final void run() {
        k.a(this.tPo, this.dAs);
    }
}

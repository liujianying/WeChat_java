package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.q;
import com.tencent.mm.ui.chatting.b.o.1;
import com.tencent.mm.ui.chatting.viewitems.i$b;

class o$1$2 implements Runnable {
    final /* synthetic */ 1 tPE;
    final /* synthetic */ q tPF;

    o$1$2(1 1, q qVar) {
        this.tPE = 1;
        this.tPF = qVar;
    }

    public final void run() {
        i$b.l(this.tPF.bGO.bGP, this.tPF.bGO.bGQ, this.tPF.bGO.status);
    }
}

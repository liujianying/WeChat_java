package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.o;

class ah$10 implements Runnable {
    final /* synthetic */ ah tSj;
    final /* synthetic */ g tSv;
    final /* synthetic */ int tSw;

    ah$10(ah ahVar, int i, g gVar) {
        this.tSj = ahVar;
        this.tSw = i;
        this.tSv = gVar;
    }

    public final void run() {
        this.tSj.bAG.eX(this.tSw + 1, ((o) this.tSj.bAG.O(o.class)).cvy() + this.tSj.bAG.tTs.getTopHeight());
        this.tSv.unlock();
    }
}

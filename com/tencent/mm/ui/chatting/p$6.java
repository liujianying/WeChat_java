package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.chatting.b.b.y;

class p$6 implements Runnable {
    final /* synthetic */ p tJl;

    p$6(p pVar) {
        this.tJl = pVar;
    }

    public final void run() {
        synchronized (p.f(this.tJl)) {
            if (p.g(this.tJl)) {
                x.i("MicroMsg.ChattingFooterEventImpl", "jacks already stop before begin!!");
                return;
            }
            p.h(this.tJl);
            p.b(this.tJl).J(100, 100);
            p.a(this.tJl, false);
            p.c(this.tJl).J(200, 200);
            p.d(this.tJl).Ci(p.e(this.tJl).getListView().getHeight());
            d cwl = ((ag) p.e(this.tJl).O(ag.class)).cwl();
            cwl.hnA = true;
            cwl.csQ();
            cwl.csL();
            p.i(this.tJl);
            this.tJl.tJh.setKeepScreenOn(true);
            ((y) p.e(this.tJl).O(y.class)).Fe(3);
            ((y) p.e(this.tJl).O(y.class)).keepSignalling();
            p.cts();
            ((ag) p.e(this.tJl).O(ag.class)).a(p.e(this.tJl).tTq, true);
        }
    }
}

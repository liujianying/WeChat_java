package com.tencent.mm.ui.chatting.g;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.ah.a;
import com.tencent.mm.ui.chatting.g.b.4;

class b$4$1 implements ah {
    final /* synthetic */ 4 tYi;

    b$4$1(4 4) {
        this.tYi = 4;
    }

    public final void cug() {
    }

    public final void a(a aVar) {
        if (aVar == a.tMx) {
            1 1 = new 1(this);
            1.bJC = this.tYi.dAB.field_msgId;
            this.tYi.tYf.gBc.remove(1);
            this.tYi.tYf.tYc.remove(1);
        }
    }

    public final void b(a aVar) {
        x.i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", new Object[]{Thread.currentThread(), aVar});
        if (aVar == a.tMx) {
            this.tYi.tYf.tYa.RR.notifyChanged();
        }
    }

    public final boolean cuh() {
        return true;
    }
}

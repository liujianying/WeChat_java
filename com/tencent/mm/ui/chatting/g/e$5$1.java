package com.tencent.mm.ui.chatting.g;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.ah.a;
import com.tencent.mm.ui.chatting.g.e.5;

class e$5$1 implements ah {
    final /* synthetic */ 5 tYx;

    e$5$1(5 5) {
        this.tYx = 5;
    }

    public final void cug() {
    }

    public final void a(a aVar) {
        if (aVar == a.tMx) {
            this.tYx.tYu.gBc.removeAll(this.tYx.gco);
        }
    }

    public final void b(a aVar) {
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[requestExitSelectedMode] %s del size:%s job:%s", new Object[]{Thread.currentThread(), Integer.valueOf(this.tYx.gco.size()), aVar});
        if (aVar == a.tMx) {
            this.tYx.tYu.tYo.cwy();
        }
    }

    public final boolean cuh() {
        return true;
    }
}

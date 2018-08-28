package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ac.a.e;
import com.tencent.mm.ui.chatting.b.b.g;

class c$2 implements Runnable {
    final /* synthetic */ c tOm;

    c$2(c cVar) {
        this.tOm = cVar;
    }

    public final void run() {
        if (this.tOm.bAG != null) {
            boolean isInEditMode = ((g) this.tOm.bAG.O(g.class)).isInEditMode();
            if (this.tOm.qIZ && !isInEditMode) {
                e.d(this.tOm.tDV);
            }
        }
    }
}

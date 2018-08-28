package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.chatting.gallery.i.a;

class i$12 implements Runnable {
    final /* synthetic */ i tWK;

    i$12(i iVar) {
        this.tWK = iVar;
    }

    public final void run() {
        i.h(this.tWK);
        i.a(this.tWK, i.i(this.tWK));
        i.d(this.tWK).bv(false);
        i.j(this.tWK);
        if (i.c(this.tWK)) {
            i.b(this.tWK, bi.VF());
            i.f(this.tWK).cxB();
            i.f(this.tWK).reset();
            i.a(this.tWK, false);
            i.k(this.tWK);
        }
        t.c(i.a(this.tWK), 0, i.c(this.tWK));
        if (i.l(this.tWK) != null) {
            a aVar = (a) i.l(this.tWK).get(i.a(this.tWK));
            if (aVar != null) {
                j cwO = this.tWK.tTx.cwO();
                cwO.cxz().tXa.stop();
                i.a(this.tWK, 0);
                this.tWK.a(cwO, aVar.bGS, aVar.pos);
                this.tWK.FI(0);
                if (cwO.cxz().tXi.getVisibility() != 8) {
                    cwO.cxz().tXi.setVisibility(8);
                }
            }
        }
    }
}

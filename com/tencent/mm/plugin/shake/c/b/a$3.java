package com.tencent.mm.plugin.shake.c.b;

import com.tencent.mm.g.a.pe;
import com.tencent.mm.plugin.shake.c.b.a.a;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements Runnable {
    final /* synthetic */ a mYd;
    final /* synthetic */ pe mYe;

    a$3(a aVar, pe peVar) {
        this.mYd = aVar;
        this.mYe = peVar;
    }

    public final void run() {
        x.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback");
        a.a(this.mYd, this.mYe.cab);
        if (a.g(this.mYd) != null) {
            a.b(this.mYd, 8);
            if (a.g(this.mYd) != null) {
                a.a(this.mYd, a.g(this.mYd).cac);
            }
            if (a.g(this.mYd) == null || !a.g(this.mYd).bLW) {
                a.a(this.mYd, a.mYi);
                a.h(this.mYd);
                a.k(this.mYd);
                return;
            }
            a.a(this.mYd, a.mYh);
            a.h(this.mYd);
            a.i(this.mYd);
            a.j(this.mYd);
            if (a.a(this.mYd) != null) {
                a.a(this.mYd).buR();
                return;
            }
            return;
        }
        x.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback, mCardAcceptResult == null");
    }
}

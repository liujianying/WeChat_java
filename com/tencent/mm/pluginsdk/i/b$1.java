package com.tencent.mm.pluginsdk.i;

import com.tencent.mm.compatible.a.a$a;

class b$1 implements a$a {
    final /* synthetic */ int iSC;
    final /* synthetic */ b qDV;

    b$1(b bVar, int i) {
        this.qDV = bVar;
        this.iSC = i;
    }

    public final void run() {
        if (this.qDV.lik != null) {
            this.qDV.lik.setOrientationHint(this.iSC);
        }
    }
}

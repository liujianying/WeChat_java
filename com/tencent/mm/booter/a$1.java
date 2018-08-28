package com.tencent.mm.booter;

import com.tencent.mm.sdk.platformtools.ar.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    final /* synthetic */ a cWA;

    a$1(a aVar) {
        this.cWA = aVar;
    }

    public final void fn(int i) {
        switch (i) {
            case 0:
                x.v("MicroMsg.BackgroundPlayer", "call end");
                this.cWA.xu();
                return;
            case 1:
            case 2:
                x.v("MicroMsg.BackgroundPlayer", "call start");
                this.cWA.xv();
                return;
            default:
                return;
        }
    }
}

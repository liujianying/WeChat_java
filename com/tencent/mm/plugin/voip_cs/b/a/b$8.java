package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.R;

class b$8 implements Runnable {
    final /* synthetic */ b oXY;

    b$8(b bVar) {
        this.oXY = bVar;
    }

    public final void run() {
        a bMD = a.bMD();
        if (bMD.oNt != null) {
            bMD.oNt.o(R.k.playend, 0, true);
        }
    }
}

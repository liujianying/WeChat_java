package com.tencent.mm.plugin.offline;

import com.tencent.mm.plugin.offline.h.1;
import com.tencent.mm.sdk.platformtools.x;

class h$1$1 implements Runnable {
    final /* synthetic */ 1 lJc;

    h$1$1(1 1) {
        this.lJc = 1;
    }

    public final void run() {
        x.d("MicroMsg.OfflineProcess", "tofutest do callback");
        this.lJc.lJb.a(this.lJc.fEY, 0, h.b(this.lJc.lJb));
        this.lJc.uXK.bNx();
    }
}

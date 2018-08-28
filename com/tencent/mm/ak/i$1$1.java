package com.tencent.mm.ak;

import com.tencent.mm.ak.i.1;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class i$1$1 implements Runnable {
    final /* synthetic */ 1 dVb;

    i$1$1(1 1) {
        this.dVb = 1;
    }

    public final void run() {
        x.i("MicroMsg.ImgService", "on image upload end. queue size : " + this.dVb.dVa.dUW.size());
        this.dVb.dVa.dUY = false;
        if (this.dVb.dVa.dUW.size() > 0) {
            l lVar = (l) this.dVb.dVa.dUW.poll();
            if (lVar != null) {
                x.i("MicroMsg.ImgService", "upload image scene hashcode : " + lVar.hashCode());
                g.Eh().dpP.a(lVar, 0);
                this.dVb.dVa.dUY = true;
                return;
            }
            x.w("MicroMsg.ImgService", "poll image scene is null");
        }
    }
}

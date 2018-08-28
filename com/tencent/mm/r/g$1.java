package com.tencent.mm.r;

import com.tencent.mm.sdk.platformtools.x;

class g$1 implements Runnable {
    final /* synthetic */ g diM;

    g$1(g gVar) {
        this.diM = gVar;
    }

    public final void run() {
        x.i("MicroMsg.NetSceneGetFuncMsg", "do retry");
        if (this.diM.a(this.diM.dIX, this.diM.diJ) == -1) {
            this.diM.diJ.a(3, -1, "doScene failed", this.diM);
        }
    }
}

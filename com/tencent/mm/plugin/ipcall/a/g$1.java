package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.x;

class g$1 extends a {
    final /* synthetic */ g koK;

    g$1(g gVar) {
        this.koK = gVar;
    }

    public final void ev(int i) {
        int i2 = 0;
        x.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", new Object[]{Integer.valueOf(i)});
        if (i.aXq().kqA) {
            f aXt = i.aXt();
            if (aXt.mCurrentState == 4 || aXt.mCurrentState == 5) {
                i2 = 1;
            }
            if (i2 != 0 && i == 4 && this.koK.koF != null) {
                this.koK.koF.a(this.koK.koG);
            }
        }
    }
}

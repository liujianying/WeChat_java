package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.game.gamewebview.ui.b.a;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements a {
    final /* synthetic */ boolean[] gmQ;
    final /* synthetic */ Runnable gmT;
    final /* synthetic */ c jIM;

    c$3(c cVar, boolean[] zArr, Runnable runnable) {
        this.jIM = cVar;
        this.gmQ = zArr;
        this.gmT = runnable;
    }

    public final void amF() {
        x.d("MicroMsg.GameWebPageContainer", "onLoadFinish, costTime = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - c.b(this.jIM))});
        if (!this.gmQ[0]) {
            x.d("MicroMsg.GameWebPageContainer", "removeCallback, %d", new Object[]{Integer.valueOf(this.gmT.hashCode())});
            this.jIM.removeCallbacks(this.gmT);
            this.jIM.post(this.gmT);
        }
    }
}

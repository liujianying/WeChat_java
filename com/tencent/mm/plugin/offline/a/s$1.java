package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class s$1 implements Runnable {
    final /* synthetic */ boolean lKy = false;
    final /* synthetic */ s lKz;

    s$1(s sVar) {
        this.lKz = sVar;
    }

    public final void run() {
        x.v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
        g.Ek();
        g.Eh().dpP.a(new b(this.lKy), 0);
    }
}

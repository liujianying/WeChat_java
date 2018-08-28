package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.sdk.platformtools.x;

class c$15 implements a {
    final /* synthetic */ c lLe;
    final /* synthetic */ g lLf;

    c$15(c cVar, g gVar) {
        this.lLe = cVar;
        this.lLf = gVar;
    }

    public final void blf() {
        if (this.lLe.lKZ != null) {
            this.lLe.lKZ.o(0, this.lLf.id, "");
        }
        com.tencent.mm.plugin.offline.g.bR(this.lLf.bQa, com.tencent.mm.plugin.offline.g.lIT);
        x.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
    }
}

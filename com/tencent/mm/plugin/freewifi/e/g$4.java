package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class g$4 implements Runnable {
    final /* synthetic */ g jkP;
    final /* synthetic */ String jkQ;
    final /* synthetic */ ep jkR;

    g$4(g gVar, String str, ep epVar) {
        this.jkP = gVar;
        this.jkQ = str;
        this.jkR = epVar;
    }

    public final void run() {
        String Cc = g.Cc(this.jkQ);
        x.i("MicroMsg.FreeWifi.ProtocolOne", "get redirect location from loginurl : %s, %s", new Object[]{Cc, this.jkQ});
        if (!bi.oW(Cc)) {
            String cQ = g.cQ(Cc, "res=");
            x.i("MicroMsg.FreeWifi.ProtocolOne", "get connect result from location : %s, %s", new Object[]{cQ, Cc});
            if (!bi.oW(cQ) && (cQ.startsWith("success") || cQ.startsWith("already"))) {
                FreeWifiFrontPageUI freeWifiFrontPageUI = this.jkP.jkG;
                d dVar = d.jnk;
                b bVar = new b();
                bVar.jng = this.jkR;
                freeWifiFrontPageUI.a(dVar, bVar);
                return;
            }
        }
        g.c(this.jkP);
    }
}

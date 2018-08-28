package com.tencent.mm.plugin.collect.a;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.collect.b.g;
import com.tencent.mm.plugin.collect.b.u;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.c.aup;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a implements ar {
    private com.tencent.mm.model.bv.a hTD = new 1(this);
    private g hTE = new g();
    private u hTF = new u();

    public static a aBC() {
        return (a) p.v(a.class);
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().a("paymsg", this.hTD, true);
        g gVar = this.hTE;
        gVar.cht();
        gVar.hTS = new ConcurrentLinkedQueue();
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(1384, gVar);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(1317, gVar);
        this.hTF.cht();
    }

    public final void onAccountRelease() {
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().b("paymsg", this.hTD, true);
        g gVar = this.hTE;
        gVar.dead();
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(1384, gVar);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(1317, gVar);
        g.aBI();
        this.hTF.dead();
    }

    public static com.tencent.mm.plugin.collect.b.d aBD() {
        com.tencent.mm.kernel.g.Eg().Ds();
        return com.tencent.mm.plugin.collect.b.d.hTL;
    }

    public static boolean aBE() {
        String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(com.tencent.mm.storage.aa.a.sVy, "");
        long GK = q.GK();
        if (bi.oW(str) || str.equals("in.caf")) {
            return (GK & 32768) != 0;
        } else {
            x.i("MicroMsg.SubCoreCollect", "old version switch is open, sync to new version");
            com.tencent.mm.kernel.g.Ei().DT().set(147457, Long.valueOf(GK | 32768));
            aup aup = new aup();
            aup.mEc = 1;
            ((i) com.tencent.mm.kernel.g.l(i.class)).FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(209, aup));
            return true;
        }
    }

    public final void aBF() {
        yC("cash.caf");
        com.tencent.mm.kernel.g.Ei().DT().a(com.tencent.mm.storage.aa.a.sVy, "cash.caf");
    }

    public final void aBG() {
        yC("in.caf");
        com.tencent.mm.kernel.g.Ei().DT().a(com.tencent.mm.storage.aa.a.sVy, "in.caf");
    }

    private void yC(String str) {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(304, new 2(this));
        com.tencent.mm.plugin.collect.b.o oVar = new com.tencent.mm.plugin.collect.b.o(bi.aG(str, ""));
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(oVar, 0);
    }
}

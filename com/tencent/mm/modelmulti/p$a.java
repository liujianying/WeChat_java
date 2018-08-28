package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.p.b;
import com.tencent.mm.modelmulti.p.c;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

class p$a {
    int dZl;
    boolean eaB;
    awe eaC;
    b eaD;
    c eaE;
    al eaF;
    final /* synthetic */ p eay;

    private p$a(p pVar, c cVar, boolean z, awe awe, b bVar) {
        this.eay = pVar;
        this.dZl = 0;
        this.eaB = false;
        this.eaC = null;
        this.eaD = null;
        this.eaF = new al(g.Em().lnJ.getLooper(), new 1(this), true);
        this.eaD = bVar;
        this.eaE = cVar;
        this.eaB = z;
        this.eaC = awe;
        this.dZl = 0;
        String str = "";
        boolean z2 = (this.eaD == null || this.eaE == null) ? false : true;
        p.F(str, z2);
        if (this.eaC == null) {
            p.F("resp Not null", false);
            x.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", new Object[]{this.eaE});
            this.eaD.ie(0);
            return;
        }
        if (g.Eg().Dx() && !a.Dr()) {
            g.Ek();
            if (g.Ei() != null) {
                g.Ek();
                if (g.Ei().DT() != null) {
                    p.a(awe);
                    long j = (long) awe.rZy;
                    if (String.valueOf(j).length() == 10) {
                        j *= 1000;
                    }
                    long currentTimeMillis = System.currentTimeMillis() - j;
                    long j2 = currentTimeMillis / 1000;
                    x.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(j), Long.valueOf(currentTimeMillis), Long.valueOf(j2)});
                    g.Ek();
                    g.Ei().DT().a(aa.a.sWU, Long.valueOf(currentTimeMillis));
                    g.Ek();
                    g.Eg().aW(this.eaC.hcd, this.eaC.rZx);
                    g.Ek();
                    g.Eg();
                    a.gH(this.eaC.hcd);
                    if (this.eaC.rnB == null || this.eaC.rnB.hbG == null || this.eaC.rnB.hbG.size() <= 0) {
                        x.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", new Object[]{this.eaE});
                        p.a(z, this.eaC, this.eaE);
                        this.eaD.ie(0);
                        return;
                    }
                    x.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", new Object[]{this.eaE, Integer.valueOf(this.eaC.rnB.hbG.size()), Integer.valueOf(this.eaC.hcd), Integer.valueOf(this.eaC.rZx)});
                    this.eaF.J(50, 50);
                    return;
                }
            }
        }
        Object[] objArr = new Object[4];
        objArr[0] = this.eaE;
        objArr[1] = Boolean.valueOf(g.Eg().Dx());
        objArr[2] = Boolean.valueOf(a.Dr());
        g.Ek();
        objArr[3] = g.Ei();
        x.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", objArr);
        this.eaD.ie(0);
    }
}

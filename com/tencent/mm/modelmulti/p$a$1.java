package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class p$a$1 implements a {
    final /* synthetic */ p.a eaG;

    p$a$1(p.a aVar) {
        this.eaG = aVar;
    }

    public final boolean vD() {
        if (g.Eg().Dx() && !com.tencent.mm.kernel.a.Dr()) {
            g.Ek();
            if (g.Ei() != null) {
                g.Ek();
                if (g.Ei().DT() != null) {
                    LinkedList linkedList = this.eaG.eaC.rnB.hbG;
                    c cVar = new c();
                    cVar.bD(this.eaG.eaE);
                    long VF = bi.VF();
                    while (this.eaG.dZl < linkedList.size()) {
                        linkedList.size();
                        if (!cVar.a((pm) linkedList.get(this.eaG.dZl), false)) {
                            f.mDy.a(99, 46, 1, false);
                        }
                        p.a aVar = this.eaG;
                        aVar.dZl++;
                        x.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", new Object[]{this.eaG.eaE, Long.valueOf(bi.bH(VF)), Integer.valueOf(linkedList.size()), Integer.valueOf(this.eaG.dZl - 1)});
                        if (bi.bH(VF) >= 500) {
                            break;
                        }
                    }
                    cVar.bE(this.eaG.eaE);
                    if (this.eaG.dZl < linkedList.size()) {
                        x.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", new Object[]{this.eaG.eaE, Long.valueOf(bi.bH(VF)), Integer.valueOf(linkedList.size()), Integer.valueOf(this.eaG.dZl - 1)});
                        return true;
                    }
                    p.a(this.eaG.eaB, this.eaG.eaC, this.eaG.eaE);
                    this.eaG.eaD.ie(linkedList.size());
                    return false;
                }
            }
        }
        Object[] objArr = new Object[4];
        objArr[0] = this.eaG.eaE;
        objArr[1] = Boolean.valueOf(g.Eg().Dx());
        objArr[2] = Boolean.valueOf(com.tencent.mm.kernel.a.Dr());
        g.Ek();
        objArr[3] = g.Ei();
        x.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", objArr);
        this.eaG.eaD.ie(0);
        return false;
    }
}

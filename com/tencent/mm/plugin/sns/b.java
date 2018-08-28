package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.ey;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class b extends c<ey> {
    public b() {
        this.sFo = ey.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        boolean z = false;
        ey eyVar = (ey) bVar;
        if (!(eyVar instanceof ey)) {
            x.f("MicroMsg.ExtGetSnsDataEventListener", "mismatched event");
            return false;
        } else if (eyVar.bMM.bMO == null) {
            return false;
        } else {
            n nVar = new n();
            nVar.d(eyVar.bMM.bMO);
            if (nVar.nJc <= 0) {
                x.e("MicroMsg.ExtGetSnsDataEventListener", "sns == null || sns.getLocalid()<=0");
                return false;
            }
            bsu bAJ = nVar.bAJ();
            eyVar.bMN.bMT = 0;
            eyVar.bMN.bMX = 0;
            eyVar.bMN.bMY = 0;
            eyVar.bMN.bMV = new LinkedList();
            eyVar.bMN.bMW = new LinkedList();
            if (bAJ.sqc != null) {
                eyVar.bMN.bMT = bAJ.sqc.ruz;
                if (bAJ.sqc.ruz != 1 && bAJ.sqc.ruz != 7 && bAJ.sqc.ruz != 8) {
                    eyVar.bMN.bMV.add(bAJ.sqc.jPK);
                } else if (bAJ.sqc.ruA != null) {
                    while (true) {
                        boolean z2 = z;
                        if (z2 >= bAJ.sqc.ruA.size()) {
                            break;
                        }
                        List list = eyVar.bMN.bMV;
                        af.byl();
                        list.add(g.r((ate) bAJ.sqc.ruA.get(z2)));
                        list = eyVar.bMN.bMW;
                        af.byl();
                        list.add(g.s((ate) bAJ.sqc.ruA.get(z2)));
                        if (!(z2 || bAJ.sqc.ruA.get(z2) == null)) {
                            eyVar.bMN.bMX = (int) ((ate) bAJ.sqc.ruA.get(z2)).rVH.rWu;
                            eyVar.bMN.bMY = (int) ((ate) bAJ.sqc.ruA.get(z2)).rVH.rWv;
                        }
                        z = z2 + 1;
                    }
                }
            }
            eyVar.bMN.bMU = eyVar.bMN.bMV.size();
            eyVar.bMN.bMQ = nVar.nJc;
            eyVar.bMN.bMP = nVar.field_userName;
            eyVar.bMN.bMR = bAJ.spZ;
            eyVar.bMN.bMS = (long) bAJ.lOH;
            return true;
        }
    }
}

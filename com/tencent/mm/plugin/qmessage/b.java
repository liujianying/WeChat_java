package com.tencent.mm.plugin.qmessage;

import com.tencent.mm.g.a.mc;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

public final class b extends c<mc> {
    public b() {
        this.sFo = mc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        mc mcVar = (mc) bVar;
        switch (mcVar.bWF.opType) {
            case 0:
                String str = mcVar.bWF.bWH;
                String str2 = mcVar.bWF.bWI;
                au.HU();
                ab Yg = com.tencent.mm.model.c.FR().Yg(str);
                if (Yg == null || ((int) Yg.dhP) == 0) {
                    Yg = new ab(str);
                    Yg.Bh();
                    Yg.dx(str2);
                    Yg.eM(4);
                    au.HU();
                    com.tencent.mm.model.c.FR().T(Yg);
                    com.tencent.mm.aa.c.jL(Yg.field_username);
                }
                d JM = g.boc().JM(str);
                if (JM == null || bi.oV(JM.getUsername()).length() <= 0) {
                    JM = new d();
                    JM.bWA = -1;
                    JM.mbv = 1;
                    JM.username = str;
                    JM.mbw = 0;
                    JM.mbx = 0;
                    if (!g.boc().a(JM)) {
                        x.e("MicroMsg.QMsgExtension", "processModQContact: insert qcontact failed");
                    }
                }
                mcVar.bWG.bJm = true;
                break;
            case 1:
                d JM2 = g.boc().JM(mcVar.bWF.bWJ);
                if (JM2 != null && bi.oV(JM2.getUsername()).length() > 0) {
                    if (JM2.mbw != ((long) mcVar.bWF.bWK) || JM2.mbx != ((long) mcVar.bWF.bWL)) {
                        JM2.mbv = 1;
                        JM2.username = mcVar.bWF.bWJ;
                        JM2.mbw = (long) mcVar.bWF.bWK;
                        JM2.mbx = (long) mcVar.bWF.bWL;
                        JM2.bWA = 56;
                        if (!g.boc().a(JM2.getUsername(), JM2)) {
                            x.e("MicroMsg.QMsgOperationListener", "processModQContact: update qcontact failed");
                        }
                        mcVar.bWG.bJm = true;
                        break;
                    }
                    mcVar.bWG.bJm = true;
                    break;
                }
                JM2 = new d();
                JM2.bWA = -1;
                JM2.mbv = 1;
                JM2.username = mcVar.bWF.bWJ;
                JM2.mbw = (long) mcVar.bWF.bWK;
                JM2.mbx = (long) mcVar.bWF.bWL;
                if (!g.boc().a(JM2)) {
                    x.e("MicroMsg.QMsgOperationListener", "processModQContact: insert qcontact failed");
                }
                mcVar.bWG.bJm = true;
                break;
                break;
            case 2:
                g.bod();
                break;
        }
        return false;
    }
}

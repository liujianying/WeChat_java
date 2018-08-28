package com.tencent.mm.plugin.luckymoney.b;

import android.net.Uri;
import android.os.Looper;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.to;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g$a;
import java.util.ArrayList;
import java.util.Iterator;

public final class aj implements e {
    boolean kRF;
    public ag kRG;
    public ad kRH;
    private w kRI;
    public c kRJ = new c<to>() {
        {
            this.sFo = to.class.getName().hashCode();
        }

        private boolean a(to toVar) {
            if (toVar instanceof to) {
                switch (toVar.cfd.action) {
                    case 1:
                        aj ajVar = aj.this;
                        long j = toVar.cfd.bIZ;
                        if (!ajVar.kRF) {
                            ajVar.kRF = true;
                            bd dW = ((i) g.l(i.class)).bcY().dW(j);
                            String str = dW.field_content;
                            g$a J = str != null ? g$a.J(str, dW.field_reserved) : null;
                            if (J != null) {
                                String oV = bi.oV(J.dyc);
                                Uri parse = Uri.parse(oV);
                                String queryParameter = parse.getQueryParameter("sendid");
                                int i = bi.getInt(parse.getQueryParameter("channelid"), 1);
                                if (ajVar.kRG != null) {
                                    g.Ek();
                                    g.Eh().dpP.c(ajVar.kRG);
                                    ajVar.kRG = null;
                                }
                                g.Ek();
                                g.Eh().dpP.a(1581, ajVar);
                                ajVar.kRG = new ag(i, queryParameter, oV, 3, "v1.0");
                                ajVar.kRG.talker = dW.field_talker;
                                ajVar.kRG.bJC = j;
                                g.Ek();
                                g.Eh().dpP.a(ajVar.kRG, 0);
                                break;
                            }
                        }
                        break;
                }
            }
            return false;
        }
    };

    public aj() {
        a.sFg.b(this.kRJ);
    }

    public final void a(int i, int i2, String str, l lVar) {
        g.Ek();
        g.Eh().dpP.b(1581, this);
        g.Ek();
        g.Eh().dpP.b(1685, this);
        g.Ek();
        g.Eh().dpP.b(1585, this);
        if (lVar instanceof ag) {
            ag agVar = (ag) lVar;
            if (i != 0 || i2 != 0) {
                this.kRF = false;
                dU(agVar.bJC);
            } else if (agVar.ceS == 4) {
                if (this.kRI != null) {
                    g.Ek();
                    g.Eh().dpP.c(this.kRI);
                    this.kRI = null;
                }
                g.Ek();
                g.Eh().dpP.a(1585, this);
                this.kRI = new w(agVar.kLZ, 11, 0, agVar.ceR, "v1.0");
                this.kRI.talker = agVar.talker;
                this.kRI.bJC = agVar.bJC;
                g.Ek();
                g.Eh().dpP.a(this.kRI, 0);
                x.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
            } else if (agVar.ceT == 1 || agVar.ceS == 5 || agVar.ceS == 1) {
                this.kRF = false;
                x.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
                dU(agVar.bJC);
            } else {
                if (this.kRH != null) {
                    g.Ek();
                    g.Eh().dpP.c(this.kRH);
                    this.kRH = null;
                }
                g.Ek();
                g.Eh().dpP.a(1685, this);
                this.kRH = new ad(agVar.msgType, agVar.bxk, agVar.kLZ, agVar.ceR, o.baX(), q.GH(), agVar.talker, "v1.0", agVar.kRC);
                this.kRH.bJC = agVar.bJC;
                g.Ek();
                g.Eh().dpP.a(this.kRH, 0);
                x.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
            }
        } else if (lVar instanceof ad) {
            this.kRF = false;
            ad adVar = (ad) lVar;
            if (i == 0 && i2 == 0) {
                f fVar = adVar.kQP;
                if (fVar.ceT == 2) {
                    a(fVar, adVar.bJC, adVar.talker);
                    return;
                } else {
                    dU(adVar.bJC);
                    return;
                }
            }
            dU(adVar.bJC);
        } else if (lVar instanceof w) {
            this.kRF = false;
            w wVar = (w) lVar;
            if (i == 0 && i2 == 0) {
                a(wVar.kQP, wVar.bJC, wVar.talker);
            } else {
                dU(wVar.bJC);
            }
        }
    }

    private static void dU(long j) {
        to toVar = new to();
        toVar.cfd.action = 2;
        toVar.cfe.bIZ = j;
        toVar.cfe.cfh = 0;
        toVar.cfe.cfi = "";
        a.sFg.a(toVar, Looper.getMainLooper());
    }

    private static void a(f fVar, long j, String str) {
        to toVar = new to();
        toVar.cfd.action = 2;
        toVar.cfe.bIZ = j;
        toVar.cfe.cfh = fVar.cfh;
        toVar.cfe.cfi = fVar.kPW;
        toVar.cfe.cfj = new ArrayList();
        if (s.fq(str)) {
            Iterator it = fVar.kQe.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                toVar.cfe.cfj.add(com.tencent.mm.aa.q.KJ().jR(nVar.kQD) + "=" + nVar.kQC + "=" + nVar.kQp);
            }
        }
        a.sFg.a(toVar, Looper.getMainLooper());
    }
}

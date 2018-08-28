package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.aa.j;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.aqt;
import com.tencent.mm.protocal.c.aqu;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class c extends l implements k {
    private final b diG;
    private e diJ;

    public c(int i, float f, float f2, int i2, int i3, String str, String str2) {
        if (!(i == 1 || i == 2 || i == 3 || i == 4)) {
            x.e("MicroMsg.NetSceneLbsP", "OpCode Error :" + i);
        }
        a aVar = new a();
        aVar.dIG = new aqt();
        aVar.dIH = new aqu();
        aVar.uri = "/cgi-bin/micromsg-bin/lbsfind";
        aVar.dIF = 148;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aqt aqt = (aqt) this.diG.dID.dIL;
        aqt.qZc = i;
        aqt.rmr = f;
        aqt.rms = f2;
        aqt.ryV = i2;
        aqt.ryW = str;
        aqt.ryX = str2;
        aqt.ryY = i3;
        aqt.rTr = new bhy().bq(com.tencent.mm.plugin.normsg.a.b.lFJ.bjE());
        x.d("MicroMsg.NetSceneLbsP", "Req: opcode:" + i + " lon:" + f + " lat:" + f2 + " pre:" + i2 + " gpsSource:" + i3 + " mac" + str + " cell:" + str2 + " ccdLen:" + aqt.rTr.siI);
        o.a(2001, f, f2, i2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 148;
    }

    public final int Oh() {
        return ((aqt) this.diG.dID.dIL).qZc;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneLbsP", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aqu aqu = (aqu) ((b) qVar).dIE.dIL;
        List arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= aqu.rHc.size()) {
                break;
            }
            j jVar = new j();
            jVar.username = ((aqp) aqu.rHc.get(i5)).hbL;
            jVar.csA = ((aqp) aqu.rHc.get(i5)).rcm;
            jVar.dHR = ((aqp) aqu.rHc.get(i5)).rqZ;
            jVar.dHQ = ((aqp) aqu.rHc.get(i5)).rra;
            jVar.by(true);
            arrayList.add(jVar);
            i4 = i5 + 1;
        }
        com.tencent.mm.aa.q.KH().L(arrayList);
        if (Oh() == 1 || Oh() == 3 || Oh() == 4) {
            if (i2 == 0 || i3 != -2001) {
                au.HU();
                com.tencent.mm.model.c.DT().set(8210, Long.valueOf(System.currentTimeMillis() + ((long) (aqu.rTs * 1000))));
            } else {
                au.HU();
                com.tencent.mm.model.c.DT().set(8210, Long.valueOf(0));
                this.diJ.a(i2, i3, str, this);
                return;
            }
        } else if (Oh() == 2) {
            au.HU();
            com.tencent.mm.model.c.DT().set(8210, Long.valueOf(0));
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final boolean biQ() {
        return ((aqu) this.diG.dIE.dIL).rTt == 1;
    }

    public final int biR() {
        return ((aqu) this.diG.dIE.dIL).rTu;
    }

    public final List<aqp> biS() {
        List<aqp> list = ((aqu) this.diG.dIE.dIL).rHc;
        if (list != null) {
            for (aqp aqp : list) {
                au.HU();
                com.tencent.mm.model.c.Gw().fX(aqp.hbL, aqp.rEJ);
            }
        }
        return list;
    }
}

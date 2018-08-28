package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.bnz;
import com.tencent.mm.protocal.c.boa;
import com.tencent.mm.protocal.c.boc;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.protocal.c.boi;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpm;
import com.tencent.mm.protocal.c.bqx;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends l implements com.tencent.mm.network.k {
    private b diG;
    public e diJ;
    private String nnN;
    private boi nnO;
    private int type;

    public k(boi boi, String str, String str2) {
        bqx nn;
        a aVar = new a();
        aVar.dIG = new bnz();
        aVar.dIH = new boa();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
        aVar.dIF = 682;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bnz bnz = (bnz) this.diG.dID.dIL;
        bnz.slU = boi;
        this.type = boi.smo.hcE;
        this.nnO = boi;
        bnz.rcc = str;
        this.nnN = str;
        com.tencent.mm.plugin.sns.storage.e eZ = af.byr().eZ(boi.rlK);
        if (eZ != null) {
            bsu bAJ = eZ.bAJ();
            if (bAJ != null) {
                nn = p.nn(bAJ.nNV);
            } else {
                x.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[]{Long.valueOf(r2)});
                nn = null;
            }
        } else {
            x.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[]{Long.valueOf(r2)});
            nn = null;
        }
        if (nn != null) {
            bnz.slV = ab.oT(p.a(nn));
            bnz.rdq = nn.source;
        }
        bnz.slT = ab.oT(bi.aG(str2, ""));
        x.i("MicroMsg.NetSceneSnsAdComment", boi.smo.seC + " " + boi.smo.rxF + " type " + boi.smo.hcE + " aduxinfo " + str2 + ", SnsStat=" + bnz.slV + ", source=" + bnz.rdq);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 682;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsAdComment", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            af.byn().d(this.nnO.rlK, this.type, this.nnN);
            boh boh = this.nnO.smo;
            if (boh.hcE == 1 || boh.hcE == 2 || boh.hcE == 3 || boh.hcE == 5 || boh.hcE == 7 || boh.hcE == 8) {
                bon bon = new bon();
                bon.lOH = boh.lOH;
                bon.hcE = boh.hcE;
                bon.rdq = boh.rdq;
                bon.rdS = boh.seC;
                bon.rTW = boh.sme;
                bon.jSA = boh.jSA;
                bon.smm = boh.smm;
                try {
                    boy boy;
                    bnz bnz = (bnz) this.diG.dID.dIL;
                    boa boa = (boa) this.diG.dIE.dIL;
                    if (bnz.rdq == 1 || bnz.rdq == 2) {
                        bpm bpm = boa.sgK;
                        boy = bpm.slX;
                        a.a(bpm);
                    } else {
                        boc boc = boa.rcB;
                        boy = boc.slX;
                        a.a(boc);
                    }
                    x.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + boy.toString() + " " + boy.smL.size() + " " + boy.smO.size());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", e, "", new Object[0]);
                }
            }
            af.byn().bxP();
        } else if (i2 == 4) {
            af.byn().d(this.nnO.rlK, this.type, this.nnN);
        }
        this.diJ.a(i2, i3, str, this);
    }
}

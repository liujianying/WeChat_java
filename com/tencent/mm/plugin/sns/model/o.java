package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.protocal.c.boi;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.boo;
import com.tencent.mm.protocal.c.bop;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpg;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

public final class o extends l implements k {
    private b diG;
    public e diJ;
    private String nnN;
    private boi nnO;
    private int type;

    public o(boi boi, String str) {
        a aVar = new a();
        aVar.dIG = new boo();
        aVar.dIH = new bop();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnscomment";
        aVar.dIF = 213;
        aVar.dII = 100;
        aVar.dIJ = 1000000100;
        this.diG = aVar.KT();
        boo boo = (boo) this.diG.dID.dIL;
        boo.slU = boi;
        this.type = boi.smo.hcE;
        this.nnO = boi;
        boo.rcc = str;
        this.nnN = str;
        x.d("MicroMsg.NetSceneSnsComment", boi.smo.seC + " " + boi.smo.rxF);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        n fi = af.byo().fi(this.nnO.rlK);
        if (fi == null) {
            com.tencent.mm.plugin.sns.storage.e eZ = af.byr().eZ(this.nnO.rlK);
            if (eZ != null) {
                fi = eZ.bAL();
            }
        }
        if (fi != null) {
            try {
                boy boy = (boy) new boy().aG(fi.field_attrBuf);
                if (boy.smY != null && boy.smY.siL) {
                    bpg bpg = (bpg) new bpg().aG(boy.smY.siK.lR);
                    boo boo = (boo) this.diG.dID.dIL;
                    if (bpg.snn != null) {
                        x.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", new Object[]{String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[]{Integer.valueOf(bpg.snn.rvt), Integer.valueOf(bpg.snn.rvu)})});
                        boo.slV = new bhz().VO(r0);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsComment", e, "", new Object[0]);
            }
        }
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 213;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsComment", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            af.byn().d(this.nnO.rlK, this.type, this.nnN);
            boh boh = this.nnO.smo;
            if (boh.hcE == 1 || boh.hcE == 2 || boh.hcE == 3 || boh.hcE == 5) {
                bon bon = new bon();
                bon.lOH = boh.lOH;
                bon.hcE = boh.hcE;
                bon.rdq = boh.rdq;
                bon.rdS = boh.seC;
                bon.rTW = boh.sme;
                bon.jSA = boh.jSA;
                bon.smm = boh.smm;
                try {
                    boy boy = ((bop) this.diG.dIE.dIL).slX;
                    if (boh.hcE == 1 || boh.hcE == 5) {
                        x.i("MicroMsg.NetSceneSnsComment", "snsComment:" + boy.rlK + " " + ab.b(boy.smH) + " " + boy.smL.size() + " " + boy.smO.size());
                    } else {
                        x.i("MicroMsg.NetSceneSnsComment", "snsComment:" + boy.rlK + " " + boy.smL.size() + " " + boy.smO.size());
                    }
                    aj.d(boy);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneSnsComment", e, "", new Object[0]);
                }
            }
            af.byn().bxP();
        } else if (i2 == 4) {
            af.byn().d(this.nnO.rlK, this.type, this.nnN);
        }
        this.diJ.a(i2, i3, str, this);
    }
}

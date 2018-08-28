package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.protocal.c.bfg;
import com.tencent.mm.protocal.c.bfh;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends l implements k {
    private b diG;
    private e diJ;

    public h(com.tencent.mm.plugin.address.d.b bVar) {
        a aVar = new a();
        aVar.dIG = new bfg();
        aVar.dIH = new bfh();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoupdate";
        aVar.dIF = 418;
        aVar.dII = 203;
        aVar.dIJ = 1000000203;
        this.diG = aVar.KT();
        bfg bfg = (bfg) this.diG.dID.dIL;
        bfg.sgs = new bez();
        bfg.sgs.id = bVar.id;
        bfg.sgs.sgz = new bhz().VO(bi.aG(bVar.eXZ, ""));
        bfg.sgs.sgx = new bhz().VO(bi.aG(bVar.eXX, ""));
        bfg.sgs.sgC = new bhz().VO(bi.aG(bVar.eYc, ""));
        bfg.sgs.sgA = new bhz().VO(bi.aG(bVar.eYa, ""));
        bfg.sgs.sgD = new bhz().VO(bi.aG(bVar.eYd, ""));
        bfg.sgs.sgE = new bhz().VO(bi.aG(bVar.eYe, ""));
        bfg.sgs.sgy = new bhz().VO(bi.aG(bVar.eXY, ""));
        bfg.sgs.sgB = new bhz().VO(bi.aG(bVar.eYb, ""));
        bfg.sgs.sgF = new bhz().VO(bi.aG(bVar.eYf, ""));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRcptInfoUpdate", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bfh bfh = (bfh) ((b) qVar).dIE.dIL;
            if (bfh.sgt.sgw != null) {
                x.d("MicroMsg.NetSceneRcptInfoUpdate", "resp.rImpl.rcptinfolist.rcptinfolist " + bfh.sgt.sgw.size());
                com.tencent.mm.plugin.address.a.a.Zv();
                com.tencent.mm.plugin.address.a.a.Zx().q(bfh.sgt.sgw);
                com.tencent.mm.plugin.address.a.a.Zv();
                com.tencent.mm.plugin.address.a.a.Zx().Zz();
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 418;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}

package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.beu;
import com.tencent.mm.protocal.c.bev;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class c extends l implements k {
    private b diG;
    private e diJ;

    public c(com.tencent.mm.plugin.address.d.b bVar) {
        a aVar = new a();
        aVar.dIG = new beu();
        aVar.dIH = new bev();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
        aVar.dIF = TbsListener$ErrorCode.INFO_INITX5_FALSE_DEFAULT;
        aVar.dII = 200;
        aVar.dIJ = 1000000200;
        this.diG = aVar.KT();
        beu beu = (beu) this.diG.dID.dIL;
        beu.sgs = new bez();
        beu.sgs.sgz = new bhz().VO(bi.aG(bVar.eXZ, ""));
        beu.sgs.sgx = new bhz().VO(bi.aG(bVar.eXX, ""));
        beu.sgs.sgC = new bhz().VO(bi.aG(bVar.eYc, ""));
        beu.sgs.sgA = new bhz().VO(bi.aG(bVar.eYa, ""));
        beu.sgs.sgD = new bhz().VO(bi.aG(bVar.eYd, ""));
        beu.sgs.sgE = new bhz().VO(bi.aG(bVar.eYe, ""));
        beu.sgs.sgy = new bhz().VO(bi.aG(bVar.eXY, ""));
        beu.sgs.sgB = new bhz().VO(bi.aG(bVar.eYb, ""));
        beu.sgs.sgF = new bhz().VO(bi.aG(bVar.eYf, ""));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRcptInfoAdd", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bev bev = (bev) ((b) qVar).dIE.dIL;
            if (bev.sgt.sgw != null) {
                x.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + bev.sgt.sgw.size());
                com.tencent.mm.plugin.address.a.a.Zv();
                com.tencent.mm.plugin.address.a.a.Zx().q(bev.sgt.sgw);
                com.tencent.mm.plugin.address.a.a.Zv();
                com.tencent.mm.plugin.address.a.a.Zx().Zz();
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return TbsListener$ErrorCode.INFO_INITX5_FALSE_DEFAULT;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}

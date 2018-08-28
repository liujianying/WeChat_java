package com.tencent.mm.plugin.address.model;

import com.tencent.mm.a.o;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bew;
import com.tencent.mm.protocal.c.bex;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l implements k {
    private b diG;
    private e diJ;
    public int status;

    public d(String str, String str2, o oVar) {
        boolean z = true;
        a aVar = new a();
        aVar.dIG = new bew();
        aVar.dIH = new bex();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoimport";
        aVar.dIF = 582;
        aVar.dII = 0;
        aVar.dIJ = 0;
        String str3 = "MicroMsg.NetSceneRcptInfoImportYiXun";
        StringBuilder append = new StringBuilder("a2key is ").append(!bi.oW(str)).append(", newa2key is ");
        if (bi.oW(str2)) {
            z = false;
        }
        x.d(str3, append.append(z).toString());
        this.diG = aVar.KT();
        bew bew = (bew) this.diG.dID.dIL;
        bew.reB = new bhy().bq(bi.WP(str));
        bew.sgu = new bhy().bq(bi.WP(str2));
        bew.qq = oVar.intValue();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRcptInfoImportYiXun", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bex bex = (bex) ((b) qVar).dIE.dIL;
            this.status = bex.sgv;
            x.d("MicroMsg.NetSceneRcptInfoImportYiXun", "status : " + this.status);
            if (bex.sgt.sgw != null && this.status == 0) {
                x.d("MicroMsg.NetSceneRcptInfoImportYiXun", "resp.rImpl.rcptinfolist.rcptinfolist " + bex.sgt.sgw.size());
                com.tencent.mm.plugin.address.a.a.Zv();
                com.tencent.mm.plugin.address.a.a.Zx().q(bex.sgt.sgw);
                com.tencent.mm.plugin.address.a.a.Zv();
                com.tencent.mm.plugin.address.a.a.Zx().Zz();
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 582;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}

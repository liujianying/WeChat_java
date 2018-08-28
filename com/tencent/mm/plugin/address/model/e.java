package com.tencent.mm.plugin.address.model;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfa;
import com.tencent.mm.protocal.c.bfb;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    private b diG;
    private com.tencent.mm.ab.e diJ;
    public boolean eXH;
    public String nickname;
    public String username;

    public e(String str, String str2, int i) {
        a aVar = new a();
        aVar.dIG = new bfa();
        aVar.dIH = new bfb();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
        aVar.dIF = 417;
        aVar.dII = CdnLogic.kAppTypeYunStorage;
        aVar.dIJ = 1000000202;
        this.diG = aVar.KT();
        bfa bfa = (bfa) this.diG.dID.dIL;
        bfa.timestamp = 0;
        bfa.sgG = str;
        bfa.bPS = str2;
        bfa.scene = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        boolean z = true;
        x.d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bfb bfb = (bfb) ((b) qVar).dIE.dIL;
            this.username = bfb.iEL;
            this.nickname = bfb.sgJ;
            if (bfb.sgI != 1) {
                z = false;
            }
            this.eXH = z;
            if (bfb.sgt.sgw != null) {
                x.d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + bfb.sgt.sgw.size());
                com.tencent.mm.plugin.address.a.a.Zv();
                com.tencent.mm.plugin.address.a.a.Zx().q(bfb.sgt.sgw);
                com.tencent.mm.plugin.address.a.a.Zv();
                com.tencent.mm.plugin.address.a.a.Zx().Zz();
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 417;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}

package com.tencent.mm.plugin.sns.a.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apy;
import com.tencent.mm.protocal.c.apz;
import com.tencent.mm.protocal.c.bk;
import com.tencent.mm.protocal.c.bl;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.List;

public final class e extends l implements k {
    private b diG;
    public com.tencent.mm.ab.e diJ;
    public List<apz> gxs;

    public e(List<apz> list) {
        int i = 0;
        a aVar = new a();
        this.gxs = list;
        aVar.dIG = new bk();
        aVar.dIH = new bl();
        aVar.uri = "/cgi-bin/mmux-bin/adlog";
        aVar.dIF = 1802;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bk bkVar = (bk) this.diG.dID.dIL;
        apy apy = new apy();
        apy.rjL = d.qVI;
        apy.rjM = d.qVH;
        apy.rjN = d.qVK;
        apy.rjO = d.qVL;
        apy.rjP = w.chP();
        apy.rSA = (int) (System.currentTimeMillis() / 1000);
        bkVar.rbM = apy;
        while (i < list.size()) {
            bkVar.rbN.add(list.get(i));
            i++;
        }
        x.i("MicroMsg.NetSceneAdLog", "report count: " + bkVar.rbN.size());
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 1802;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneAdLog", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            int i4 = ((bl) ((b) qVar).dIE.dIL).rbO;
            g.Ek();
            g.Ei().DT().a(aa.a.sQI, Integer.valueOf(i4));
        }
        this.diJ.a(i2, i3, str, this);
    }
}

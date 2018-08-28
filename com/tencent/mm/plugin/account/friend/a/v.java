package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.aa.c;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class v extends l implements k {
    private b diG;
    private e diJ;
    public int opType;

    public v(int i, String str) {
        this.opType = i;
        a aVar = new a();
        aVar.dIG = new vj();
        aVar.dIH = new vk();
        aVar.uri = "/cgi-bin/micromsg-bin/facebookauth";
        this.diG = aVar.KT();
        vj vjVar = (vj) this.diG.dID.dIL;
        if (bi.oW(str)) {
            str = "";
        }
        vjVar.ryE = str;
        vjVar.jRb = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 183;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneFaceBookAuth", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            vk vkVar = (vk) this.diG.dIE.dIL;
            int i4 = vkVar.six.rfn;
            if (i4 != 0) {
                x.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = " + i4);
                this.diJ.a(4, i4, str, this);
                return;
            }
            x.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + vkVar.ryG + ", fbusername = " + vkVar.ryH);
            if (this.opType == 0 || this.opType == 1) {
                g.Ei().DT().set(65825, vkVar.ryG);
                c.jH(vkVar.ryG);
                g.Ei().DT().set(65826, vkVar.ryH);
                g.Ei().DT().lm(true);
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}

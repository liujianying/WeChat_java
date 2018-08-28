package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.aab;
import com.tencent.mm.protocal.c.aac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.LinkedList;

public final class c extends l implements k {
    private b diG;
    private e diJ;
    public LinkedList<String> piZ;

    public c(LinkedList<String> linkedList) {
        x.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
        a aVar = new a();
        aVar.dIG = new aab();
        aVar.dIH = new aac();
        aVar.uri = "/cgi-bin/mmpay-bin/bankresource";
        aVar.dIF = 1650;
        this.diG = aVar.KT();
        this.diG.dIU = true;
        aab aab = (aab) this.diG.dID.dIL;
        aab.rFF = linkedList;
        aab.rmQ = i.bOL();
        if (!f.cfE()) {
            aab.rqE = f.cfF();
        }
        com.tencent.mm.wallet_core.ui.e.He(42);
    }

    public final int getType() {
        return 1650;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo onGYNetEnd,errType=" + i2 + "errCode=" + i3);
        if (i2 == 0 && i3 == 0) {
            aac aac = (aac) ((b) qVar).dIE.dIL;
            x.i("MicroMsg.NetSceneGetBankcardLogo", "respone %s", new Object[]{aac.rFG});
            this.piZ = aac.piZ;
            LinkedList linkedList = this.piZ;
            if (linkedList == null || linkedList.size() == 0) {
                x.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
            } else {
                oj ojVar = new oj();
                ojVar.bZj.bZl = linkedList;
                com.tencent.mm.sdk.b.a.sFg.m(ojVar);
            }
            g.Ek();
            g.Ei().DT().a(aa.a.sTa, bi.aG(aac.rFG, ""));
            g.Ek();
            g.Ei().DT().a(aa.a.sTb, Long.valueOf(System.currentTimeMillis() / 1000));
        } else {
            com.tencent.mm.wallet_core.ui.e.He(43);
        }
        this.diJ.a(i2, i3, str, this);
    }
}

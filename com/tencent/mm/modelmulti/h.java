package com.tencent.mm.modelmulti;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbf;
import com.tencent.mm.protocal.c.bbg;
import com.tencent.mm.protocal.c.bue;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends l implements k {
    private int dZg = 0;
    private b diG;
    private e diJ;

    public h(int i, String str) {
        a aVar = new a();
        aVar.dIG = new bbf();
        aVar.dIH = new bbg();
        aVar.uri = "/cgi-bin/micromsg-bin/postinvitefriendsmsg";
        aVar.dIF = 1804;
        this.diG = aVar.KT();
        bbf bbf = (bbf) this.diG.dID.dIL;
        bbf.rID = i;
        bbf.rIF = str;
        if ((i & 16) > 0) {
            com.tencent.mm.ui.i.a aVar2 = new com.tencent.mm.ui.i.a();
            bue bue = new bue();
            if (aVar2.uFc == null) {
                bue = null;
            } else if (!bi.oW(aVar2.uFc.token)) {
                bue.srB = aVar2.uFc.token;
                bue.srC = aVar2.uFc.rWk;
            }
            bbf.sdt = bue;
        }
        this.dZg = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetScenePostInviteFriendsMsg", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.diJ.a(i2, i3, str, this);
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1804;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetScenePostInviteFriendsMsg", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}

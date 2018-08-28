package com.tencent.mm.modelmulti;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aep;
import com.tencent.mm.protocal.c.aeq;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    public String content = "";
    public int dZg = 0;
    private b diG;
    private com.tencent.mm.ab.e diJ;
    public String title = "";

    public e(int i) {
        a aVar = new a();
        aVar.dIG = new aep();
        aVar.dIH = new aeq();
        aVar.uri = "/cgi-bin/micromsg-bin/getinvitefriendsmsg";
        aVar.dIF = 1803;
        this.diG = aVar.KT();
        ((aep) this.diG.dID.dIL).rID = i;
        this.dZg = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetInviteFriendsMsg", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            aeq aeq = (aeq) this.diG.dIE.dIL;
            this.title = aeq.rIE;
            this.content = aeq.rIF;
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1803;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        x.d("MicroMsg.NetSceneGetInviteFriendsMsg", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}

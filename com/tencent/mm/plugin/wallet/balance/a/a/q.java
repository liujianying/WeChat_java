package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.aye;
import com.tencent.mm.protocal.c.ayf;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends l implements k {
    private e diJ;
    private b eAN;
    private aye oZA;
    public ayf oZB;

    public q(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new aye();
        aVar.dIH = new ayf();
        aVar.uri = "/cgi-bin/mmpay-bin/openlqbaccount";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.oZA = (aye) this.eAN.dID.dIL;
        this.oZA.rhb = str;
        this.oZA.saZ = str2;
        x.i("MicroMsg.NetSceneOpenLqbAccount", "NetSceneOpenLqbAccount, eCardType: %s, extraData: %s", str, str2);
    }

    public final int getType() {
        return 2996;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.oZB = (ayf) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, retcode: %s, retmsg: %s", Integer.valueOf(this.oZB.hwV), this.oZB.hwW);
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}

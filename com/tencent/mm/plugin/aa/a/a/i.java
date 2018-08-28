package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.n;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.d;

public final class i extends l implements k, d {
    private e diJ;
    private b eAN;
    private n eAW;
    public o eAX;

    public i(String str, long j, int i, String str2) {
        a aVar = new a();
        aVar.dIG = new n();
        aVar.dIH = new o();
        aVar.dIF = 1629;
        aVar.uri = "/cgi-bin/mmpay-bin/newaapay";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.eAW = (n) this.eAN.dID.dIL;
        this.eAW.qYc = str;
        this.eAW.qYv = j;
        this.eAW.scene = i;
        this.eAW.qYd = str2;
        x.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", new Object[]{this.eAW.qYc, Long.valueOf(this.eAW.qYv), Integer.valueOf(this.eAW.scene), this.eAW.qYd});
    }

    public final int getType() {
        return 1629;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.eAX = (o) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", new Object[]{Integer.valueOf(this.eAX.hUm), this.eAX.hUn, this.eAX.bXu});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}

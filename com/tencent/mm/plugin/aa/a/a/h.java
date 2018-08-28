package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.m;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends l implements k {
    private e diJ;
    private b eAN;
    private com.tencent.mm.protocal.c.l eAU;
    public m eAV;

    public h() {
        a aVar = new a();
        aVar.dIG = new com.tencent.mm.protocal.c.l();
        aVar.dIH = new m();
        aVar.dIF = 1698;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaoperation";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.eAU = (com.tencent.mm.protocal.c.l) this.eAN.dID.dIL;
    }

    public final int getType() {
        return 1698;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAAOperation", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.eAV = (m) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[]{Integer.valueOf(this.eAV.hUm), this.eAV.hUn, Integer.valueOf(this.eAV.qYq), Integer.valueOf(this.eAV.qYr), Integer.valueOf(this.eAV.qYs), Long.valueOf(this.eAV.qYt), Long.valueOf(this.eAV.qYu), this.eAV.hUy, this.eAV.hUz});
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}

package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.d;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    private com.tencent.mm.ab.e diJ;
    private b eAN;
    private d eAO;
    public com.tencent.mm.protocal.c.e eAP;
    public int scene;

    public e(String str, int i, String str2) {
        a aVar = new a();
        aVar.dIG = new d();
        aVar.dIH = new com.tencent.mm.protocal.c.e();
        aVar.dIF = 1530;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaclose";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.eAO = (d) this.eAN.dID.dIL;
        this.eAO.qYd = str2;
        this.eAO.qYc = str;
        this.eAO.scene = i;
        this.scene = i;
        x.d("MicroMsg.NetSceneAAClose", "NetSceneAAClose, billNo: %s, scene: %s", new Object[]{this.eAO.qYc, Integer.valueOf(i)});
    }

    public final int getType() {
        return 1530;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        x.i("MicroMsg.NetSceneAAClose", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAAClose", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.eAP = (com.tencent.mm.protocal.c.e) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneAAClose", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.eAP.hUm), this.eAP.hUn});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}

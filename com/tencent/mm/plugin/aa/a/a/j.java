package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.u;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends l implements k {
    private e diJ;
    private b eAN;
    private u eAY;
    public v eAZ;

    public j(String str, int i, String str2, String str3, int i2) {
        a aVar = new a();
        aVar.dIG = new u();
        aVar.dIH = new v();
        aVar.dIF = 1695;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerydetail";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.eAY = (u) this.eAN.dID.dIL;
        this.eAY.qYc = str;
        this.eAY.scene = i;
        this.eAY.qYd = str2;
        if (i == 5) {
            x.i("MicroMsg.NetSceneAAQueryDetail", "set sign and ver");
            this.eAY.sign = str3;
            this.eAY.ver = i2;
        }
        x.i("MicroMsg.NetSceneAAQueryDetail", "NetSceneAAQueryDetail, billNo: %s, scene: %s, groupId: %s", new Object[]{str, Integer.valueOf(i), str2});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAAQueryDetail", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.eAZ = (v) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneAAQueryDetail", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.eAZ.hUm), this.eAZ.hUn});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1695;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneAAQueryDetail", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }
}

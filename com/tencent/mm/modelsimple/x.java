package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bge;
import com.tencent.mm.protocal.c.bma;
import com.tencent.mm.protocal.c.bmb;

public final class x extends l implements k {
    public final b dZf;
    private e diJ;

    public x(int i, bge bge) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSetMsgRemind", "[NetSceneSetMsgRemind] opType:%s RemindId:%s time:%s Type:%s SubType:%s", new Object[]{Integer.valueOf(i), bge.shm, Integer.valueOf(bge.ixe), Integer.valueOf(bge.hcE), Integer.valueOf(bge.sdX)});
        a aVar = new a();
        aVar.dIG = new bma();
        aVar.dIH = new bmb();
        aVar.uri = "/cgi-bin/micromsg-bin/setmsgremind";
        aVar.dIF = 525;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dZf = aVar.KT();
        bma bma = (bma) this.dZf.dID.dIL;
        if (i == 0) {
            i = 1;
        }
        bma.jRb = i;
        bma.sky = bge;
    }

    public final int getType() {
        return 525;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] RemindId:%s", new Object[]{((bmb) this.dZf.dIE.dIL).shm});
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        }
        this.diJ.a(i2, i3, str, this);
    }
}

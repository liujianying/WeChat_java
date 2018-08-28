package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.nv;
import com.tencent.mm.protocal.c.nw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class a extends h {
    private final String TAG = "MicroMsg.NetSceneCheckHoneyPayer";
    public nw kjA;

    public a() {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new nv();
        aVar.dIH = new nw();
        aVar.dIF = 2618;
        aVar.uri = "/cgi-bin/mmpay-bin/checkhoneypayer";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 2618;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneCheckHoneyPayer", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.kjA = (nw) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneCheckHoneyPayer", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.kjA.hwV), this.kjA.hwW});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        nw nwVar = (nw) ((b) qVar).dIE.dIL;
        this.uXe = nwVar.hwV;
        this.uXf = nwVar.hwW;
    }
}

package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bun;
import com.tencent.mm.protocal.c.buo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class n extends h {
    private final String TAG = "MicroMsg.NetSceneUnbindHoneyPayCard";
    public buo kjO;

    public n(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new bun();
        aVar.dIH = new buo();
        aVar.dIF = 2659;
        aVar.uri = "/cgi-bin/mmpay-bin/unbindhpcard";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bun bun = (bun) this.diG.dID.dIL;
        bun.rIw = str;
        bun.ruV = str2;
    }

    public final int getType() {
        return 2659;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneUnbindHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.kjO = (buo) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneUnbindHoneyPayCard", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.kjO.hwV), this.kjO.hwW});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        buo buo = (buo) ((b) qVar).dIE.dIL;
        this.uXe = buo.hwV;
        this.uXf = buo.hwW;
    }
}

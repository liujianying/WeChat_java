package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aml;
import com.tencent.mm.protocal.c.amm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class f extends h {
    private final String TAG = "MicroMsg.NetSceneHoneyPayerList";
    public amm kjF;

    public f() {
        a aVar = new a();
        aVar.dIG = new aml();
        aVar.dIH = new amm();
        aVar.dIF = 2725;
        aVar.uri = "/cgi-bin/mmpay-bin/honeypayerlist";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 2725;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneHoneyPayerList", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.kjF = (amm) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneHoneyPayerList", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.kjF.hwV), this.kjF.hwW});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        amm amm = (amm) ((b) qVar).dIE.dIL;
        this.uXe = amm.hwV;
        this.uXf = amm.hwW;
    }
}

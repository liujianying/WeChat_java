package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.c.bdh;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class l extends h {
    private final String TAG = "MicroMsg.NetSceneQryHoneyPayerDetail";
    public bdi kjM;

    public l(String str) {
        a aVar = new a();
        aVar.dIG = new bdh();
        aVar.dIH = new bdi();
        aVar.dIF = 2876;
        aVar.uri = "/cgi-bin/mmpay-bin/qryhppayerdetail";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((bdh) this.diG.dID.dIL).rIw = str;
        x.i("MicroMsg.NetSceneQryHoneyPayerDetail", "card no: %s", new Object[]{str});
    }

    public final int getType() {
        return 2876;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQryHoneyPayerDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.kjM = (bdi) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneQryHoneyPayerDetail", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.kjM.hwV), this.kjM.hwW});
        if (this.kjM.rIx != null) {
            c.R(this.kjM.rIx.bXu, this.kjM.rIx.rlP, this.kjM.rIx.rlQ);
        }
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bdi bdi = (bdi) ((b) qVar).dIE.dIL;
        this.uXe = bdi.hwV;
        this.uXf = bdi.hwW;
    }
}

package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.c.bdj;
import com.tencent.mm.protocal.c.bdk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class m extends h {
    private final String TAG = "MicroMsg.NetSceneQryHoneyUserDetail";
    public bdk kjN;

    public m(String str) {
        a aVar = new a();
        aVar.dIG = new bdj();
        aVar.dIH = new bdk();
        aVar.dIF = 2613;
        aVar.uri = "/cgi-bin/mmpay-bin/qryhpusererdetail";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((bdj) this.diG.dID.dIL).rIw = str;
        x.i("MicroMsg.NetSceneQryHoneyUserDetail", "card no: %s", new Object[]{str});
    }

    public final int getType() {
        return 2613;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQryHoneyUserDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.kjN = (bdk) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneQryHoneyUserDetail", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.kjN.hwV), this.kjN.hwW});
        if (this.kjN.rIx != null) {
            c.R(this.kjN.rIx.bXu, this.kjN.rIx.rlP, this.kjN.rIx.rlQ);
        }
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bdk bdk = (bdk) ((b) qVar).dIE.dIL;
        this.uXe = bdk.hwV;
        this.uXf = bdk.hwW;
    }
}

package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.bdg;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class k extends h {
    private final String TAG = "MicroMsg.NetSceneQryHoneyPayCardDetail";
    public bdg kjL;

    public k(String str) {
        a aVar = new a();
        aVar.dIG = new bdf();
        aVar.dIH = new bdg();
        aVar.dIF = 2851;
        aVar.uri = "/cgi-bin/mmpay-bin/qryhpcarddetail";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((bdf) this.diG.dID.dIL).rIw = str;
    }

    public final int getType() {
        return 2851;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQryHoneyPayCardDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.kjL = (bdg) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneQryHoneyPayCardDetail", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.kjL.hwV), this.kjL.hwW});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bdg bdg = (bdg) ((b) qVar).dIE.dIL;
        this.uXe = bdg.hwV;
        this.uXf = bdg.hwW;
    }
}

package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.acm;
import com.tencent.mm.protocal.c.acn;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class d extends h {
    private final String TAG = "MicroMsg.NetSceneGetCreateTokenSign";
    public acn kjD;

    public d(String str, long j) {
        a aVar = new a();
        aVar.dIG = new acm();
        aVar.dIH = new acn();
        aVar.dIF = 2630;
        aVar.uri = "/cgi-bin/mmpay-bin/createhpcardtoken";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        acm acm = (acm) this.diG.dID.dIL;
        acm.rsa = str;
        acm.ruW = j;
        acm.rHf = i.bOM();
        x.i("MicroMsg.NetSceneGetCreateTokenSign", "take_message: %s, credit_line: %s", new Object[]{str, Long.valueOf(j)});
    }

    public final int getType() {
        return 2630;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneGetCreateTokenSign", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.kjD = (acn) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneGetCreateTokenSign", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.kjD.hwV), this.kjD.hwW});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        acn acn = (acn) ((b) qVar).dIE.dIL;
        this.uXe = acn.hwV;
        this.uXf = acn.hwW;
    }
}

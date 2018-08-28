package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aff;
import com.tencent.mm.protocal.c.afg;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class g extends h {
    private final String TAG = "MicroMsg.NetSceneMCreditLineTokenSign";
    public afg kjG;

    public g(String str, long j) {
        a aVar = new a();
        aVar.dIG = new aff();
        aVar.dIH = new afg();
        aVar.dIF = 2815;
        aVar.uri = "/cgi-bin/mmpay-bin/gmcreditlinetoken";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aff aff = (aff) this.diG.dID.dIL;
        aff.rIw = str;
        aff.ruW = j;
        x.i("MicroMsg.NetSceneMCreditLineTokenSign", "card_no: %s, credit_line: %s", new Object[]{str, Long.valueOf(j)});
    }

    public final int getType() {
        return 2815;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneMCreditLineTokenSign", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.kjG = (afg) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneMCreditLineTokenSign", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.kjG.hwV), this.kjG.hwW});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        afg afg = (afg) ((b) qVar).dIE.dIL;
        this.uXe = afg.hwV;
        this.uXf = afg.hwW;
    }
}

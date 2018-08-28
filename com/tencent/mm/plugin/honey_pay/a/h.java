package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.avd;
import com.tencent.mm.protocal.c.ave;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends com.tencent.mm.wallet_core.c.h {
    private final String TAG = "MicroMsg.NetSceneModifyHoneyPayerCreditLine";
    public ave kjH;
    public long kjI;

    public h(long j, String str, String str2) {
        a aVar = new a();
        aVar.dIG = new avd();
        aVar.dIH = new ave();
        aVar.dIF = 2865;
        aVar.uri = "/cgi-bin/mmpay-bin/modifyhppayercreditline";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        avd avd = (avd) this.diG.dID.dIL;
        avd.ruW = j;
        avd.ruV = str;
        avd.rIw = str2;
        this.kjI = j;
        x.d("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "cardNo: %s, authToken: %s", new Object[]{str2, str});
        x.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "credit line: %s", new Object[]{Long.valueOf(j)});
    }

    public final int getType() {
        return 2865;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.kjH = (ave) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.kjH.hwV), this.kjH.hwW});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        ave ave = (ave) ((b) qVar).dIE.dIL;
        this.uXe = ave.hwV;
        this.uXf = ave.hwW;
    }
}

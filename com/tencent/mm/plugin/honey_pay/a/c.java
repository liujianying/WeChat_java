package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.protocal.c.qq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class c extends h {
    private final String TAG = "MicroMsg.NetSceneCreateHoneyPayCard";
    public qq kjC;

    public c(String str, long j, String str2, String str3, int i, String str4) {
        a aVar = new a();
        aVar.dIG = new qp();
        aVar.dIH = new qq();
        aVar.dIF = 2662;
        aVar.uri = "/cgi-bin/mmpay-bin/createhoneypaycard";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        qp qpVar = (qp) this.diG.dID.dIL;
        qpVar.ruV = str;
        qpVar.ruW = j;
        qpVar.rrW = str2;
        qpVar.rsa = str3;
        qpVar.huV = i;
        qpVar.kLf = str4;
        x.d("MicroMsg.NetSceneCreateHoneyPayCard", "token: %s, take message: %s, wishing: %s", new Object[]{str, str3, str4});
        x.i("MicroMsg.NetSceneCreateHoneyPayCard", "username: %s, credit line: %s", new Object[]{str2, Long.valueOf(j)});
    }

    public final int getType() {
        return 2662;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneCreateHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.kjC = (qq) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneCreateHoneyPayCard", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.kjC.hwV), this.kjC.hwW});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        qq qqVar = (qq) ((b) qVar).dIE.dIL;
        this.uXe = qqVar.hwV;
        this.uXf = qqVar.hwW;
    }
}

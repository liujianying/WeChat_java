package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.protocal.c.bao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class j extends h {
    private final String TAG = "MicroMsg.NetSceneModifyHoneyPayerPayWay";
    private avi kjK;

    public j(bao bao, String str) {
        a aVar = new a();
        aVar.dIG = new avh();
        aVar.dIH = new avi();
        aVar.dIF = 2941;
        aVar.uri = "/cgi-bin/mmpay-bin/modifyhppayerpayway";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        avh avh = (avh) this.diG.dID.dIL;
        avh.rPo = bao;
        avh.rIw = str;
        x.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "cardNo: %s, suffix: %s, bankType: %s", new Object[]{str, bao.scZ, bao.lMV});
    }

    public final int getType() {
        return 2941;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.kjK = (avi) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.kjK.hwV), this.kjK.hwW});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        avi avi = (avi) ((b) qVar).dIE.dIL;
        this.uXe = avi.hwV;
        this.uXf = avi.hwW;
    }
}

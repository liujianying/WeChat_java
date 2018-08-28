package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.avf;
import com.tencent.mm.protocal.c.avg;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class i extends h {
    private final String TAG = "MicroMsg.NetSceneModifyHoneyPayerNotify";
    public int bWA;
    private avg kjJ;

    public i(int i) {
        a aVar = new a();
        aVar.dIG = new avf();
        aVar.dIH = new avg();
        aVar.dIF = 2742;
        aVar.uri = "/cgi-bin/mmpay-bin/modifyhppayernotify";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((avf) this.diG.dID.dIL).peW = i;
        this.bWA = i;
        x.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "notify flag: %s", new Object[]{Integer.valueOf(i)});
    }

    public final int getType() {
        return 2742;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.kjJ = (avg) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.kjJ.hwV), this.kjJ.hwW});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        avg avg = (avg) ((b) qVar).dIE.dIL;
        this.uXe = avg.hwV;
        this.uXf = avg.hwW;
    }
}

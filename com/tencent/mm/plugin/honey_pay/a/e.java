package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.aej;
import com.tencent.mm.protocal.c.aek;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class e extends h {
    private final String TAG = "MicroMsg.NetSceneGetHoneyPayCard";
    public aek kjE;

    public e(String str) {
        a aVar = new a();
        aVar.dIG = new aej();
        aVar.dIH = new aek();
        aVar.dIF = 1983;
        aVar.uri = "/cgi-bin/mmpay-bin/gethpcard";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aej aej = (aej) this.diG.dID.dIL;
        aej.rIw = str;
        aej.rHf = i.bOM();
        x.i("MicroMsg.NetSceneGetHoneyPayCard", "card no: %s", new Object[]{str});
    }

    public final int getType() {
        return 1983;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneGetHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.kjE = (aek) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneGetHoneyPayCard", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.kjE.hwV), this.kjE.hwW});
        if (this.kjE.rIx != null) {
            c.R(this.kjE.rIx.bXu, this.kjE.rIx.rlP, this.kjE.rIx.rlQ);
        }
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        aek aek = (aek) ((b) qVar).dIE.dIL;
        this.uXe = aek.hwV;
        this.uXf = aek.hwW;
    }
}

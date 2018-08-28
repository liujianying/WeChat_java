package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.mp;
import com.tencent.mm.protocal.c.mq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class e extends h {
    private final String TAG = "MicroMsg.NetSceneBeforeTransfer";
    public mq mwY;

    public e(String str) {
        a aVar = new a();
        aVar.dIG = new mp();
        aVar.dIH = new mq();
        aVar.dIF = 2783;
        aVar.uri = "/cgi-bin/mmpay-bin/beforetransfer";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        mp mpVar = (mp) this.diG.dID.dIL;
        mpVar.rcH = str;
        if (!f.cfE()) {
            mpVar.rqE = f.cfF();
        }
        x.d("MicroMsg.NetSceneBeforeTransfer", "rcver name: %s", new Object[]{str});
    }

    protected final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBeforeTransfer", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.mwY = (mq) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBeforeTransfer", "ret_code: %s, ret_msg: %s", new Object[]{Integer.valueOf(this.mwY.hUm), this.mwY.hUn});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        mq mqVar = (mq) ((b) qVar).dIE.dIL;
        this.uXe = mqVar.hUm;
        this.uXf = mqVar.hUn;
    }

    public final int getType() {
        return 2783;
    }
}

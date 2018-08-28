package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.protocal.c.jn;
import com.tencent.mm.protocal.c.jo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.d;

public final class l extends com.tencent.mm.ab.l implements k, d, com.tencent.mm.wallet_core.d.d {
    private e diJ;
    private b eAN;
    public boolean iMC = false;
    public jo mxo;
    public boolean mxp = false;
    private jn mxq;

    public l(btd btd, ch chVar, String str, int i, String str2) {
        a aVar = new a();
        aVar.dIG = new jn();
        aVar.dIH = new jo();
        aVar.dIF = 2682;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fzerocallback";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.mxq = (jn) this.eAN.dID.dIL;
        this.mxq.rkA = chVar;
        this.mxq.rkR = btd;
        this.mxq.rkS = str;
        this.mxq.rld = i;
        this.mxq.token = str2;
        x.i("MicroMsg.NetSceneBusiF2fZeroCallback", "NetSceneBusiF2fZeroCallback, token %s AfterPlaceOrderCommReq %s zero_pay_extend: %s", new Object[]{str2, a.a(chVar), str});
    }

    public final int getType() {
        return 2682;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fZeroCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.mxo = (jo) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBusiF2fZeroCallback", "ret_code: %s, ret_msg: %s", new Object[]{Integer.valueOf(this.mxo.hwV), this.mxo.hwW});
        if (this.diJ != null) {
            boolean z;
            if (this.mxo.rle == 1) {
                z = true;
            } else {
                z = false;
            }
            this.iMC = z;
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final boolean bre() {
        return this.mxp;
    }
}

package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.protocal.c.jf;
import com.tencent.mm.protocal.c.jg;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends l implements k {
    private e diJ;
    private b eAN;
    public jg mxi;

    public h(ch chVar, String str) {
        a aVar = new a();
        aVar.dIG = new jf();
        aVar.dIH = new jg();
        aVar.dIF = 1241;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fpaycheck";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        jf jfVar = (jf) this.eAN.dID.dIL;
        jfVar.rkA = chVar;
        jfVar.rkB = str;
        x.i("MicroMsg.NetSceneBusiF2fPayCheck", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s req: %s", new Object[]{chVar.rcD, chVar.rcE, Integer.valueOf(chVar.rcI), a.a(chVar)});
    }

    public final int getType() {
        return 1241;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.mxi = (jg) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBusiF2fPayCheck", "ret_code: %s, ret_msg: %s", new Object[]{Integer.valueOf(this.mxi.hwV), this.mxi.hwW});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}

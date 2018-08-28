package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.protocal.c.jl;
import com.tencent.mm.protocal.c.jm;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends l implements com.tencent.mm.network.k {
    private e diJ;
    private b eAN;
    public jm mxn;

    public k(ch chVar, String str) {
        a aVar = new a();
        aVar.dIG = new jl();
        aVar.dIH = new jm();
        aVar.dIF = 2702;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2funlockfavor";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        jl jlVar = (jl) this.eAN.dID.dIL;
        jlVar.rkA = chVar;
        jlVar.rkN = str;
        x.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "NetSceneBusiF2fUnlockFavor, f2fId: %s, transId: %s, amount: %s", new Object[]{chVar.rcD, chVar.rcE, Integer.valueOf(chVar.rcI)});
    }

    public final int getType() {
        return 2702;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.mxn = (jm) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "ret_code: %s, ret_msg: %s", new Object[]{Integer.valueOf(this.mxn.hwV), this.mxn.hwW});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}

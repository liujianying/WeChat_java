package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ja;
import com.tencent.mm.protocal.c.jb;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends l implements k {
    private e diJ;
    private b eAN;
    public jb mwZ;

    public f(String str, String str2, String str3, int i, com.tencent.mm.bk.b bVar, String str4) {
        a aVar = new a();
        aVar.dIG = new ja();
        aVar.dIH = new jb();
        aVar.dIF = 1680;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2factqry";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        ja jaVar = (ja) this.eAN.dID.dIL;
        jaVar.myl = str3;
        jaVar.rcD = str;
        jaVar.rcE = str2;
        jaVar.rcI = i;
        jaVar.rkr = bVar;
        jaVar.rcF = str4;
        x.i("MicroMsg.NetSceneBusiF2fActQry", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s", new Object[]{str, str2, Integer.valueOf(i)});
    }

    public final int getType() {
        return 1680;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fActQry", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.mwZ = (jb) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBusiF2fActQry", "ret_code: %s, ret_msg: %s", new Object[]{Integer.valueOf(this.mwZ.hwV), this.mwZ.hwW});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}

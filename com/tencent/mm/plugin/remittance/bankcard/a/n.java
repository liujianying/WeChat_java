package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhe;
import com.tencent.mm.protocal.c.bhf;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.d;

public final class n extends b implements d {
    private final String TAG = "MicroMsg.NetSceneBankRemitRequestOrder";
    private b diG;
    private e diJ;
    public bhf muf;

    public n(String str, String str2, String str3, int i, int i2, String str4, int i3, int i4, String str5) {
        a aVar = new a();
        aVar.dIG = new bhe();
        aVar.dIH = new bhf();
        aVar.dIF = 1380;
        aVar.uri = "/cgi-bin/mmpay-bin/request_tsbc";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bhe bhe = (bhe) this.diG.dID.dIL;
        bhe.muA = str;
        bhe.muB = str2;
        bhe.lMV = str3;
        bhe.mun = i;
        bhe.shY = i2;
        bhe.shZ = str4;
        bhe.sia = i3;
        bhe.sib = i4;
        bhe.ref = str5;
    }

    public final int getType() {
        return 1380;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitRequestOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.muf = (bhf) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBankRemitRequestOrder", "retcode: %s, retmsg: %s", Integer.valueOf(this.muf.hUm), this.muf.hUn);
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bhf bhf = (bhf) ((b) qVar).dIE.dIL;
        this.uXe = bhf.hUm;
        this.uXf = bhf.hUn;
    }

    public final boolean aBQ() {
        if (this.muf.sic == null || this.muf.sic.bWA != 1) {
            return true;
        }
        return false;
    }
}

package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.dt;
import com.tencent.mm.protocal.c.du;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitAppointBank";
    private b diG;
    private e diJ;
    public du mtS;
    public String mtT;

    public a(String str, String str2, String str3) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new dt();
        aVar.dIH = new du();
        aVar.dIF = 1348;
        aVar.uri = "/cgi-bin/mmpay-bin/appointbank_tsbc";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        dt dtVar = (dt) this.diG.dID.dIL;
        dtVar.muA = str;
        dtVar.rec = str2;
        dtVar.lMV = str3;
        this.mtT = str;
        x.i("MicroMsg.NetSceneBankRemitAppointBank", "seqno: %s, timing_id: %s, bankType: %s", new Object[]{str, str2, str3});
    }

    public final int getType() {
        return 1348;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitAppointBank", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.mtS = (du) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBankRemitAppointBank", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.mtS.hUm), this.mtS.hUn});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        du duVar = (du) ((b) qVar).dIE.dIL;
        this.uXe = duVar.hUm;
        this.uXf = duVar.hUn;
    }
}

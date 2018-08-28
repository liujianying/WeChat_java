package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.protocal.c.bdr;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends l implements com.tencent.mm.network.k {
    private e diJ;
    private b eAN;
    public String oqH;
    private bdq pjn;
    public bdr pjo;

    public k(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new bdq();
        aVar.dIH = new bdr();
        aVar.dIF = 2710;
        aVar.uri = "/cgi-bin/mmpay-bin/mktqueryawardstatus";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.pjn = (bdq) this.eAN.dID.dIL;
        this.pjn.pwq = str;
        this.oqH = str2;
        x.i("MicroMsg.NetSceneMtkQueryAwardStatus", "NetSceneMtkQueryAwardStatus, query_award_status_params: %s, activityId: %s", new Object[]{str, str2});
    }

    public final int getType() {
        return 2710;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMtkQueryAwardStatus", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pjo = (bdr) ((b) qVar).dIE.dIL;
        if (i2 == 0 || i3 == 0) {
            x.i("MicroMsg.NetSceneMtkQueryAwardStatus", "ret_code: %s, ret_msg: %s", new Object[]{Integer.valueOf(this.pjo.hwV), this.pjo.hwW});
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}

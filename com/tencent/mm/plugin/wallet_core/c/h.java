package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zp;
import com.tencent.mm.protocal.c.zq;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends l implements k {
    private e diJ;
    private b eAN;
    private zp pjg;
    public zq pjh;
    public long pji;

    public h(String str, long j) {
        a aVar = new a();
        aVar.dIG = new zp();
        aVar.dIH = new zq();
        aVar.uri = "/cgi-bin/mmpay-bin/mktgetaward";
        aVar.dIF = 2948;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.pjg = (zp) this.eAN.dID.dIL;
        this.pjg.rFv = str;
        this.pji = j;
        x.i("MicroMsg.NetSceneMktGetAward", "NetSceneMktGetAward, get_award_params: %s, activityId: %s", new Object[]{str, Long.valueOf(j)});
    }

    public final int getType() {
        return 2948;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMktGetAward", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pjh = (zq) ((b) qVar).dIE.dIL;
        if (i2 == 0 || i3 == 0) {
            x.i("MicroMsg.NetSceneMktGetAward", "ret_code: %s, ret_msg: %s, result_code: %s, alert_wording: %s, btn_wording: %s", new Object[]{Integer.valueOf(this.pjh.hwV), this.pjh.hwW, Integer.valueOf(this.pjh.rFw), this.pjh.rFx, this.pjh.rFy});
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}

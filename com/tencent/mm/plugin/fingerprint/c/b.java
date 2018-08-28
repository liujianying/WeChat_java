package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.c.bqk;
import com.tencent.mm.protocal.c.bql;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.android.wechat.TenpayUtil;

public final class b extends d implements k {
    public final com.tencent.mm.ab.b diG;
    private e diJ;

    public b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.dIG = new bqk();
        aVar.dIH = new bql();
        aVar.uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
        aVar.dIF = 1638;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bqk bqk = (bqk) this.diG.dID.dIL;
        bqk.sba = str;
        bqk.signature = str2;
        bqk.soj = str3;
        bqk.bRr = TenpayUtil.signWith3Des("passwd=" + bqk.soj);
    }

    public final void d(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay success");
            com.tencent.mm.plugin.fingerprint.b.e.fa(true);
        } else {
            x.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
        }
        this.diJ.a(i, i2, "", this);
    }

    public final void aNJ() {
        x.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: authkey required");
        if (this.diJ != null) {
            this.diJ.a(4, -1, "", this);
        }
    }

    public final void pS(int i) {
        x.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: onError: errType: %d, errcode: %d", new Object[]{Integer.valueOf(3), Integer.valueOf(i)});
        if (this.diJ != null) {
            this.diJ.a(4, -1, "", this);
        }
    }

    public final int getType() {
        return 1638;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}

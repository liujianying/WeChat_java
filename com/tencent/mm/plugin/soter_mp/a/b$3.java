package com.tencent.mm.plugin.soter_mp.a;

import com.tencent.d.b.a.a;
import com.tencent.d.b.a.b;
import com.tencent.d.b.a.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements b<a> {
    final /* synthetic */ b oom;

    b$3(b bVar) {
        this.oom = bVar;
    }

    public final /* synthetic */ void a(e eVar) {
        a aVar = (a) eVar;
        x.i("MicroMsg.SoterControllerFingerprint", "alvinluo request authentication result errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(aVar.errCode), aVar.Yy});
        this.oom.ood = false;
        if (aVar.isSuccess()) {
            ah.i(new 1(this, aVar), 500);
            return;
        }
        com.tencent.mm.plugin.soter.c.a.dL(3, aVar.errCode);
        if (aVar.errCode == 13 || aVar.errCode == 20) {
            x.i("MicroMsg.SoterControllerFingerprint", "hy: start authen error, maybe key invalid. remove former key and give suggestion");
            com.tencent.d.b.a.Hp(2);
            this.oom.oor.errCode = 90007;
            this.oom.oor.Yy = "start fingerprint authen failed";
        } else if (aVar.errCode == 25) {
            this.oom.oor.errCode = 90010;
            this.oom.oor.Yy = "authenticate freeze. please try again later";
        } else {
            this.oom.oor.errCode = 90007;
            this.oom.oor.Yy = "authenticate error: " + aVar.Yy;
        }
        this.oom.bFs();
    }
}

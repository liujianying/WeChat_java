package com.tencent.mm.plugin.soter_mp.a;

import com.tencent.d.b.a.b;
import com.tencent.d.b.a.c;
import com.tencent.d.b.a.e;
import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements b<c> {
    final /* synthetic */ b oom;

    b$1(b bVar) {
        this.oom = bVar;
    }

    public final /* synthetic */ void a(e eVar) {
        c cVar = (c) eVar;
        x.i("MicroMsg.SoterControllerFingerprint", "hy: update mp auth key result: errcode: %d, errmsg: %s", new Object[]{Integer.valueOf(cVar.errCode), cVar.Yy});
        b.bFp();
        if (cVar.isSuccess()) {
            b.a(this.oom, false);
        } else {
            a.dL(2, cVar.errCode);
        }
        if (cVar.errCode == 12) {
            x.e("MicroMsg.SoterControllerFingerprint", "hy: model is null");
            this.oom.oor.errCode = 90007;
            this.oom.oor.Yy = "auth key can not be retrieved";
            this.oom.bFs();
        } else if (cVar.errCode == 5) {
            x.v("MicroMsg.SoterControllerFingerprint", "alvinluo: gen auth key failed, remove auth key");
            com.tencent.d.b.a.Hp(2);
            this.oom.oor.errCode = 90007;
            this.oom.oor.Yy = "auth key generate failed";
            this.oom.bFs();
        } else if (cVar.errCode == 10) {
            x.i("MicroMsg.SoterControllerFingerprint", "hy: update auth key failed. remove auth key");
            com.tencent.d.b.a.Hp(2);
            this.oom.oor.errCode = 90007;
            this.oom.oor.Yy = "auth key update error";
            this.oom.bFs();
        }
    }
}

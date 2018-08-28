package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.d.b.a.b;
import com.tencent.d.b.a.c;
import com.tencent.d.b.a.e;
import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.x;

class k$3 implements b<c> {
    final /* synthetic */ k jgS;

    k$3(k kVar) {
        this.jgS = kVar;
    }

    public final /* synthetic */ void a(e eVar) {
        c cVar = (c) eVar;
        x.i("MicroMsg.SoterAuthMgrImp", "hy: gen auth key onResult: errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(cVar.errCode), cVar.Yy});
        if (cVar.isSuccess()) {
            x.i("MicroMsg.SoterAuthMgrImp", "alvinluo gen auth key and upload success");
        } else {
            x.e("MicroMsg.SoterAuthMgrImp", "alvinluo gen or upload auth key failed");
            a.dL(2, cVar.errCode);
        }
        s.pqR.reset();
    }
}

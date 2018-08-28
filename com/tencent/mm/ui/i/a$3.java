package com.tencent.mm.ui.i;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.i.a.c;
import org.b.d.j;

class a$3 implements Runnable {
    final /* synthetic */ a uFi;

    a$3(a aVar) {
        this.uFi = aVar;
    }

    public final void run() {
        Object obj = c.uFl;
        if (this.uFi.uFc == null) {
            obj = c.uFm;
        } else {
            org.b.d.c cVar = new org.b.d.c(j.vKI, "https://api.twitter.com/1.1/account/verify_credentials.json");
            this.uFi.uFb.a(this.uFi.uFc, cVar);
            try {
                if (cVar.cKw().code != 200) {
                    obj = c.uFm;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Twitter", e, "request error.", new Object[0]);
                obj = c.uFm;
            }
        }
        this.uFi.nLo.sendMessage(this.uFi.nLo.obtainMessage(1010, obj));
    }
}

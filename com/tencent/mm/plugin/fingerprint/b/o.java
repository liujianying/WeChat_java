package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    a jgV;

    public o(a aVar) {
        this.jgV = aVar;
    }

    public final void aNI() {
        e.post(new Runnable() {
            public final void run() {
                String str = "";
                if (e.aNm()) {
                    x.i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
                    str = FingerPrintAuth.genRsaKey(e.dk(ad.getContext()), e.getUserId(), q.zz());
                } else {
                    x.e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
                }
                if (o.this.jgV != null) {
                    o.this.jgV.tp(str);
                }
            }
        }, getClass().getName());
    }
}

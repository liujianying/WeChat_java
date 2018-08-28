package com.tencent.mm.plugin.fingerprint.b;

import android.text.TextUtils;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements Runnable {
    final /* synthetic */ ag hlG;
    final /* synthetic */ d jgu;

    d$1(d dVar, ag agVar) {
        this.jgu = dVar;
        this.hlG = agVar;
    }

    public final void run() {
        if (!e.aNz()) {
            try {
                d.dj(ad.getContext());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e, "", new Object[0]);
                x.e("MicroMsg.FingerPrintMgrImpl", "init wechat ta secure world is occur exception e=" + e.getMessage());
                e.fb(false);
            }
        }
        if (!e.aNA()) {
            try {
                ClassLoader classLoader = a.class.getClassLoader();
                if (TextUtils.isEmpty(k.fh("teec"))) {
                    x.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so, because can not find the libteec");
                    e.fc(false);
                } else {
                    x.i("MicroMsg.FingerPrintMgrImpl", "LoadLibrary fingerprintauth.so, find the libteec so");
                    k.b("fingerprintauth", classLoader);
                    e.fc(true);
                }
            } catch (UnsatisfiedLinkError e2) {
                x.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e2.getMessage());
                e.fc(false);
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e3, "", new Object[0]);
                x.e("MicroMsg.FingerPrintMgrImpl", "init rsa key is occur exception e=" + e3.getMessage());
                e.fc(false);
            }
        }
        this.hlG.post(new 1(this));
    }
}

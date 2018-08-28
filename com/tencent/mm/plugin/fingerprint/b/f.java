package com.tencent.mm.plugin.fingerprint.b;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.gv.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.o;

public final class f extends c<gv> implements e {
    private String bOd;
    private boolean jgq;
    private gv jgx;
    private int jgy;
    ag jgz;

    public f() {
        this.jgy = 0;
        this.bOd = "";
        this.jgq = false;
        this.jgz = new ag(Looper.getMainLooper());
        this.sFo = gv.class.getName().hashCode();
    }

    private boolean a(gv gvVar) {
        if (g.Eg().Dx()) {
            x.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
            this.jgq = false;
            if (!(gvVar instanceof gv)) {
                return false;
            }
            if (e.aNm()) {
                this.jgx = gvVar;
                g.Ek();
                g.Eh().dpP.a(385, this);
                boolean z = this.jgx.bPW.bPY;
                this.jgy = this.jgx.bPW.bPZ;
                this.bOd = this.jgx.bPW.bQa;
                if (z) {
                    x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth should gen rsa key!");
                    z = true;
                } else {
                    Object rsaKey = FingerPrintAuth.getRsaKey(e.dk(ad.getContext()), e.getUserId(), q.zz());
                    if (TextUtils.isEmpty(rsaKey)) {
                        x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() return null");
                        z = true;
                    } else {
                        x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
                        com.tencent.mm.plugin.fingerprint.c.e eVar = new com.tencent.mm.plugin.fingerprint.c.e(rsaKey);
                        g.Ek();
                        g.Eh().dpP.a(eVar, 0);
                        z = false;
                    }
                }
                if (z) {
                    x.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
                    new o(new a(this, (byte) 0)).aNI();
                }
                return true;
            }
            x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
            b bVar = new b();
            bVar.bLW = false;
            this.jgx.bPX = bVar;
            this.jgq = true;
            awy();
            return true;
        }
        x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
        return false;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.fingerprint.c.e) {
            b bVar = new b();
            bVar.bLW = false;
            x.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
                com.tencent.mm.plugin.fingerprint.c.e eVar = (com.tencent.mm.plugin.fingerprint.c.e) lVar;
                String str2 = eVar.jgG;
                String str3 = eVar.bQc;
                String userId = e.getUserId();
                String zz = q.zz();
                String cDa = o.cDa();
                if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(e.dk(ad.getContext()), userId, zz, String.valueOf(this.jgy), cDa, "", str2, str3, Build.MODEL))) {
                    x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt failed!");
                } else {
                    x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
                    bVar.bLW = true;
                }
                String genPayFPEncrypt = FingerPrintAuth.genPayFPEncrypt(e.dk(ad.getContext()), userId, zz, String.valueOf(this.jgy), cDa, this.bOd, Build.MODEL);
                userId = FingerPrintAuth.genOpenFPSign(e.dk(ad.getContext()), e.getUserId(), q.zz(), genPayFPEncrypt);
                bVar.bQb = genPayFPEncrypt;
                bVar.bQc = userId;
            } else {
                x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is fail");
            }
            g.Ek();
            g.Eh().dpP.b(385, this);
            this.jgx.bPX = bVar;
            this.jgq = true;
            awy();
        }
    }

    private void awy() {
        x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
        if (this.jgx.bJX != null) {
            this.jgx.bJX.run();
        }
        if (this.jgq) {
            this.jgx = null;
        }
    }
}

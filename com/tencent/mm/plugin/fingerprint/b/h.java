package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.plugin.fingerprint.c.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class h implements j {
    private String bQc = null;
    private String eTo = null;
    a jgD = null;
    private a jgE = null;
    WalletBaseUI jgF = null;
    private String jgG = null;
    ag jgz = new ag(new 1(this));

    public final void a(Context context, a aVar, String str) {
        this.jgF = (WalletBaseUI) context;
        this.jgD = aVar;
        this.eTo = str;
        Object rsaKey = FingerPrintAuth.getRsaKey(e.dk(ad.getContext()), e.getUserId(), q.zz());
        com.tencent.mm.plugin.soter.c.a.bFd();
        if (TextUtils.isEmpty(rsaKey)) {
            x.e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
            new o(new a(this, (byte) 0)).aNI();
            return;
        }
        x.i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
        this.jgF.a(new e(rsaKey), false, false);
    }

    public final void clear() {
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        int i3 = 0;
        if (lVar instanceof e) {
            a aVar;
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert success");
                e eVar = (e) lVar;
                this.jgG = eVar.jgG;
                this.bQc = eVar.bQc;
                aVar = this.jgD;
                str = "";
            } else {
                x.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
                aVar = this.jgD;
                i3 = -1;
                if (bi.oW(str)) {
                    str = this.jgF.getString(i.fingerprint_open_fail);
                }
            }
            aVar.af(i3, str);
            return true;
        } else if (!(lVar instanceof f)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.soter.c.a.bFe();
                com.tencent.mm.plugin.soter.c.a.c(0, 0, 0, "OK");
                this.jgE.af(0, "");
            } else {
                this.jgE.af(-2, "");
            }
            return true;
        }
    }

    public final void a(a aVar, String str, int i) {
        this.jgE = aVar;
        if (TextUtils.isEmpty(this.eTo)) {
            x.e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
            aVar.af(-1, this.jgF.getString(i.fingerprint_open_fail));
            return;
        }
        String userId = e.getUserId();
        String zz = q.zz();
        String cDa = o.cDa();
        String str2 = "";
        CharSequence charSequence = "";
        if (e.aNm()) {
            userId = FingerPrintAuth.genOpenFPEncrypt(e.dk(ad.getContext()), userId, zz, str, cDa, "", this.jgG, this.bQc, Build.MODEL);
            charSequence = FingerPrintAuth.genOpenFPSign(e.dk(ad.getContext()), e.getUserId(), q.zz(), userId);
        } else {
            userId = str2;
        }
        if (TextUtils.isEmpty(this.jgG)) {
            x.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
        } else if (TextUtils.isEmpty(charSequence)) {
            x.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypto_open_sign which return by FingerPrintAuth.genOpenFPSign is null");
        }
        this.jgF.a(new f(userId, charSequence, this.eTo, i), false, false);
    }
}

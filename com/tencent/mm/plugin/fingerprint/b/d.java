package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.c.a.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.lg.b;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class d extends a {
    private a jgr = null;
    private a jgs = new a(this, (byte) 0);
    private c jgt = null;

    public final boolean aNh() {
        boolean z;
        boolean z2;
        int[] so = a.so();
        if (so != null) {
            for (int i : so) {
                if (1 == i) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (q.deQ.deZ == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        x.i("MicroMsg.FingerPrintMgrImpl", "hy: is hardware support: %b, is config support : %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z && z2) {
            return true;
        }
        return false;
    }

    public final boolean aNi() {
        this.jgr = a.sm();
        int[] sn = sn();
        if (sn == null || sn.length <= 0) {
            x.e("MicroMsg.FingerPrintMgrImpl", "ids is null");
        }
        aNn();
        return sn != null && sn.length > 0;
    }

    private int[] sn() {
        if (this.jgr != null) {
            return this.jgr.sn();
        }
        x.i("MicroMsg.FingerPrintMgrImpl", "getIds auth == null");
        return null;
    }

    public final void di(Context context) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setAction("com.android.settings.fingerprint.FingerprintSettings");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public final void aNj() {
        x.i("MicroMsg.FingerPrintMgrImpl", "initFP");
        if (aNh()) {
            ae bPw = o.bOW().bPw();
            if (bPw == null || bPw.bPl()) {
                ag agVar = new ag(Looper.myLooper());
                x.i("MicroMsg.FingerPrintMgrImpl", "device is support fingerprintAuth");
                e.post(new 1(this, agVar), getClass().getName());
                return;
            }
            x.e("MicroMsg.FingerPrintMgrImpl", "isSupportTouchPay is false");
            return;
        }
        x.e("MicroMsg.FingerPrintMgrImpl", "device is not support fingerprintAuth");
    }

    public static void aNk() {
        x.i("MicroMsg.FingerPrintMgrImpl", "initRsaKey");
        if (!e.aNm()) {
            x.e("MicroMsg.FingerPrintMgrImpl", "device is not support");
        } else if (o.bOW().bPp() || o.bOW().bPt()) {
            x.e("MicroMsg.FingerPrintMgrImpl", "user had not reg wxpay or is isSimpleReg");
        } else {
            try {
                String userId = e.getUserId();
                x.i("MicroMsg.FingerPrintMgrImpl", "initRsaKey userId:" + userId);
                CharSequence rsaKey = FingerPrintAuth.getRsaKey(e.dk(ad.getContext()), userId, q.zz());
                if (TextUtils.isEmpty(rsaKey)) {
                    x.e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.getRsaKey() is null");
                    rsaKey = FingerPrintAuth.genRsaKey(e.dk(ad.getContext()), e.getUserId(), q.zz());
                }
                if (TextUtils.isEmpty(rsaKey)) {
                    x.e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.genRsaKey() return null");
                } else {
                    x.e("MicroMsg.FingerPrintMgrImpl", "initRsaKey success!");
                }
            } catch (UnsatisfiedLinkError e) {
                x.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e.getMessage());
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e2, "", new Object[0]);
                x.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e2.getMessage());
            }
        }
    }

    public final boolean aNl() {
        return true;
    }

    public static void dj(Context context) {
        x.i("MicroMsg.FingerPrintMgrImpl", "initTASecureWorld");
        if (!c.aNd()) {
            x.e("MicroMsg.FingerPrintMgrImpl", "device is not support");
        } else if (e.dl(context) != 0) {
            e.fb(false);
            x.e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets failed!");
        } else {
            e.fb(true);
            x.e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets success!");
        }
    }

    public final boolean aNm() {
        return e.aNm();
    }

    public final int a(c cVar, boolean z) {
        if (this.jgr == null) {
            this.jgr = a.sm();
        }
        if (this.jgr == null) {
            return -1;
        }
        this.jgt = cVar;
        this.jgr = a.sm();
        return this.jgr.a(this.jgs, sn());
    }

    public final void aNn() {
        this.jgt = null;
        if (this.jgr != null) {
            try {
                a aVar = this.jgr;
                if (aVar.bfZ != null) {
                    aVar.bfZ.removeMessages(8);
                }
                try {
                    aVar.bfX.b(aVar.bfY);
                    aVar.bfX.asBinder().unlinkToDeath(aVar.bgd, 0);
                } catch (RemoteException e) {
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e2, "", new Object[0]);
                x.i("MicroMsg.FingerPrintMgrImpl", "auth systemRelease occur exception e:" + e2.getMessage());
            }
            this.jgr = null;
            return;
        }
        x.i("MicroMsg.FingerPrintMgrImpl", "systemRelease auth == null");
    }

    public final void aNo() {
        if (this.jgr != null) {
            try {
                this.jgr.abort();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e, "", new Object[0]);
                x.i("MicroMsg.FingerPrintMgrImpl", "auth systemAbort occur exception e:" + e.getMessage());
            }
        }
    }

    public final void a(lg lgVar, int i) {
        Object genPayFPEncrypt = FingerPrintAuth.genPayFPEncrypt(e.dk(ad.getContext()), e.getUserId(), q.zz(), String.valueOf(i), com.tencent.mm.wallet_core.c.o.cDa(), lgVar != null ? lgVar.bVz.bQa : "", Build.MODEL);
        Object genOpenFPSign = FingerPrintAuth.genOpenFPSign(e.dk(ad.getContext()), e.getUserId(), q.zz(), genPayFPEncrypt);
        if (TextUtils.isEmpty(genPayFPEncrypt)) {
            x.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_info!");
        } else {
            x.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
        }
        if (TextUtils.isEmpty(genOpenFPSign)) {
            x.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_sign!");
        } else {
            x.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
        }
        x.i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
        if (lgVar != null && lgVar.bVz.bVD != null) {
            b bVar = new b();
            bVar.bVF = 1;
            bVar.errCode = 0;
            bVar.bQb = genPayFPEncrypt;
            bVar.bQc = genOpenFPSign;
            bVar.bPZ = i;
            lgVar.bVA = bVar;
            lgVar.bVz.bVD.run();
        }
    }

    public final void aNp() {
        x.e("MicroMsg.FingerPrintMgrImpl", "hy: param incorrect");
    }

    public final j aNg() {
        return new h();
    }

    public final Map<String, String> aNq() {
        return null;
    }

    public final k aNr() {
        return null;
    }

    public final Map<String, String> aNs() {
        return null;
    }

    public final boolean aNt() {
        return true;
    }

    public final boolean a(boolean z, boolean z2, Bundle bundle) {
        return false;
    }

    public final void aNe() {
        aNo();
        aNn();
    }

    public final int type() {
        return 1;
    }
}

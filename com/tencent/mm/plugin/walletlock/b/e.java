package com.tencent.mm.plugin.walletlock.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.a.b$a;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

public final class e extends a {
    private static b pIn;

    public final void init() {
        x.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init start, call stack: %s", new Object[]{bi.i(new Throwable())});
        x.i("MicroMsg.WalletLockImpl", "alvinluo pluginSwitch %d %d", new Object[]{Integer.valueOf(r0), Integer.valueOf(bi.p(g.Ei().DT().get(40, null), 0) & 8388608)});
        g gVar;
        c cVar;
        if ((bi.p(g.Ei().DT().get(40, null), 0) & 8388608) != 0) {
            x.i("MicroMsg.WalletLockImpl", "alvinluo fingerprint wallet lock is opened");
            com.tencent.mm.plugin.walletlock.fingerprint.a.b bVar = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
            pIn = bVar;
            bVar.init();
            gVar = g.pIt;
            x.i("MicroMsg.WalletLockImpl", "alvinluo init isSupportSoter: %b, isSupportFingerprintLock: %b", new Object[]{Boolean.valueOf(h.bFl()), Boolean.valueOf(g.bSa())});
            if (com.tencent.mm.plugin.walletlock.gesture.a.b.bRE() && !r0) {
                x.i("MicroMsg.WalletLockImpl", "alvinluo has opened fingerprint lock, but device not support soter, and use gesture, isAutoJumpToGesture: %b", new Object[]{Boolean.valueOf(g.Ei().DT().getBoolean(a.sYF, false))});
                if (g.Ei().DT().getBoolean(a.sYF, false)) {
                    cVar = new c();
                    pIn = cVar;
                    cVar.init();
                    bRX();
                    return;
                }
            }
        } else if (com.tencent.mm.plugin.walletlock.gesture.a.b.bRE()) {
            x.i("MicroMsg.WalletLockImpl", "alvinluo gesture wallet lock is opened");
            cVar = new c();
            pIn = cVar;
            cVar.init();
            gVar = g.pIt;
            g.jK(false);
        } else {
            x.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock is not open");
            pIn = new a();
            gVar = g.pIt;
            g.jJ(false);
            pIn.init();
        }
        bRX();
    }

    private static void bRX() {
        x.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init end, wallet lock type: %d", new Object[]{Integer.valueOf(g.pIt.bRY())});
    }

    public final void a(Activity activity, b.b bVar) {
        if (pIn != null) {
            pIn.a(activity, bVar);
        }
    }

    public final void a(Activity activity, b.b bVar, b$a b_a) {
        if (pIn != null) {
            pIn.a(activity, bVar, b_a);
        }
    }

    public final void h(Activity activity, int i) {
        super.h(activity, i);
    }

    public final void b(Activity activity, int i, int i2) {
        super.b(activity, i, i2);
    }

    public final void K(Activity activity) {
        if (pIn != null) {
            pIn.K(activity);
        }
    }

    public final void i(Activity activity, int i) {
        Intent intent = new Intent();
        intent.putExtra("action", "action.close_wallet_lock");
        d.b(activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i);
    }

    public final b.b bRo() {
        if (pIn != null) {
            return pIn.bRo();
        }
        return null;
    }

    public final boolean bRp() {
        g gVar = g.pIt;
        if (!g.bRE()) {
            gVar = g.pIt;
            if (!g.bRt()) {
                return false;
            }
        }
        return true;
    }

    public final boolean bRq() {
        if (pIn != null) {
            return pIn.bRq();
        }
        return false;
    }

    public final void c(Activity activity, Intent intent) {
        if (pIn != null) {
            pIn.c(activity, intent);
        } else {
            super.c(activity, intent);
        }
    }

    public final void b(Activity activity, Intent intent, int i) {
        if (pIn != null) {
            pIn.b(activity, intent, i);
        } else {
            super.b(activity, intent, i);
        }
    }

    public final void zw(int i) {
        g gVar;
        if (i == 1) {
            x.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to gesture");
            c cVar = new c();
            pIn = cVar;
            cVar.init();
            gVar = g.pIt;
            g.jK(true);
        } else if (i == 2) {
            x.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to fingerprint lock");
            com.tencent.mm.plugin.walletlock.fingerprint.a.b bVar = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
            pIn = bVar;
            bVar.init();
            gVar = g.pIt;
            g.jI(false);
        } else if (i == 0) {
            x.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to none");
            a aVar = new a();
            pIn = aVar;
            aVar.init();
            gVar = g.pIt;
            g.jJ(true);
        } else {
            x.e("MicroMsg.WalletLockImpl", "alvinluo unknown wallet lock type, ignore switch");
        }
    }
}

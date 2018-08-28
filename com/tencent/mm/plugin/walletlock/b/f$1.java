package com.tencent.mm.plugin.walletlock.b;

import android.os.SystemClock;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.plugin.walletlock.fingerprint.a.a;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class f$1 extends c<ta> {
    final /* synthetic */ f pIs;

    f$1(f fVar) {
        this.pIs = fVar;
        this.sFo = ta.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ta taVar = (ta) bVar;
        x.i("MicroMsg.WalletLockInitTask", "alvinluo wallet lock protect request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", new Object[]{Integer.valueOf(taVar.cex.cez), Boolean.valueOf(i.pIx.bSf()), Boolean.valueOf(i.pIx.bSg())});
        g gVar;
        Object obj;
        long bRw;
        switch (taVar.cex.cez) {
            case 0:
                if (!(taVar.cex.activity instanceof GestureGuardLogicUI) && !(taVar.cex.activity instanceof FingerprintWalletLockUI)) {
                    gVar = g.pIt;
                    if (taVar == null) {
                        obj = null;
                    } else if (i.pIx.bSf()) {
                        x.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                        i.pIx.b(new WeakReference(taVar.cex.activity));
                        i.pIx.jM(false);
                        obj = null;
                    } else {
                        x.i("MicroMsg.WalletLockManager", "alvinluo current wallet lock type: %d", new Object[]{Integer.valueOf(gVar.mType)});
                        if (gVar.mType == 2) {
                            bRw = a.bRw();
                        } else if (gVar.mType == 1) {
                            bRw = d.bRw();
                        } else {
                            obj = null;
                        }
                        x.i("MicroMsg.WalletLockManager", "alvinluo lastVerifyOkTime: %d, elapsedRealTime: %d, pastTime: %d, PREVENT_INPUT_PWD_SECONDS: %d", new Object[]{Long.valueOf(bRw), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf((SystemClock.elapsedRealtime() - bRw) / 1000), Integer.valueOf(com.tencent.mm.plugin.walletlock.gesture.a.a.pGU)});
                        if (bRw == -1 || r2 >= ((long) com.tencent.mm.plugin.walletlock.gesture.a.a.pGU) || g.pIt.bRq()) {
                            x.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
                            obj = 1;
                        } else {
                            x.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                            i.pIx.b(new WeakReference(taVar.cex.activity));
                            obj = null;
                        }
                    }
                    if (obj == null) {
                        taVar.cey.data = Integer.valueOf(16);
                        break;
                    }
                    taVar.cey.data = Integer.valueOf(17);
                    break;
                }
                taVar.cey.data = Integer.valueOf(16);
                break;
                break;
            case 1:
                if (!(taVar.cex.activity instanceof GestureGuardLogicUI) && !(taVar.cex.activity instanceof FingerprintWalletLockUI)) {
                    gVar = g.pIt;
                    if (taVar == null) {
                        obj = null;
                    } else if (i.pIx.bSf()) {
                        x.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                        i.pIx.jM(false);
                        i.pIx.jN(false);
                        obj = null;
                    } else if (i.pIx.bSg()) {
                        x.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
                        i.pIx.jM(false);
                        i.pIx.jN(false);
                        obj = null;
                    } else {
                        x.i("MicroMsg.WalletLockManager", "alvinluo current wallet lock type: %d", new Object[]{Integer.valueOf(gVar.mType)});
                        if (gVar.mType == 2) {
                            bRw = a.bRw();
                        } else if (gVar.mType == 1) {
                            bRw = d.bRw();
                        } else {
                            obj = null;
                        }
                        i.pIx.b(new WeakReference(taVar.cex.activity));
                        x.i("MicroMsg.WalletLockManager", "alvinluo lastVerifyOkTime: %d, elapsedRealTime: %d, pastTime: %d, %d", new Object[]{Long.valueOf(bRw), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf((SystemClock.elapsedRealtime() - bRw) / 1000), Integer.valueOf(com.tencent.mm.plugin.walletlock.gesture.a.a.pGU)});
                        if (bRw == -1 || r2 >= ((long) com.tencent.mm.plugin.walletlock.gesture.a.a.pGU) || g.pIt.bRq()) {
                            x.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
                            obj = 1;
                        } else {
                            x.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                            obj = null;
                        }
                    }
                    if (obj == null) {
                        taVar.cey.data = Integer.valueOf(16);
                        break;
                    }
                    taVar.cey.data = Integer.valueOf(17);
                    break;
                }
                taVar.cey.data = Integer.valueOf(16);
                break;
                break;
        }
        taVar.cex.activity = null;
        x.i("MicroMsg.WalletLockInitTask", "alvinluo protect result: %s", new Object[]{taVar.cey.data});
        return false;
    }
}

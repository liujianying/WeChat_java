package com.tencent.mm.plugin.walletlock.b;

import android.os.SystemClock;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.plugin.walletlock.gesture.a.a;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class f$2 extends c<ta> {
    final /* synthetic */ f pIs;

    f$2(f fVar) {
        this.pIs = fVar;
        this.sFo = ta.class.getName().hashCode();
    }

    private static boolean a(ta taVar) {
        x.v("MicroMsg.WalletLockInitTask", "alvinluo gestureprotectListener request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", new Object[]{Integer.valueOf(taVar.cex.cez), Boolean.valueOf(i.pIx.bSf()), Boolean.valueOf(i.pIx.bSg())});
        long bRw;
        long elapsedRealtime;
        switch (taVar.cex.cez) {
            case 0:
                if (!(taVar.cex.activity instanceof GestureGuardLogicUI)) {
                    if (!i.pIx.bSf()) {
                        bRw = d.bRw();
                        elapsedRealtime = (SystemClock.elapsedRealtime() - bRw) / 1000;
                        if (bRw != -1 && elapsedRealtime < ((long) a.pGU) && (!b.bRF() || !b.bRE())) {
                            x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                            taVar.cey.data = Integer.valueOf(16);
                            i.pIx.b(new WeakReference(taVar.cex.activity));
                            break;
                        }
                        x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
                        taVar.cey.data = Integer.valueOf(17);
                        break;
                    }
                    x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                    taVar.cey.data = Integer.valueOf(16);
                    i.pIx.b(new WeakReference(taVar.cex.activity));
                    i.pIx.jM(false);
                    break;
                }
                x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                taVar.cey.data = Integer.valueOf(16);
                break;
                break;
            case 1:
                if (!(taVar.cex.activity instanceof GestureGuardLogicUI)) {
                    if (!i.pIx.bSf()) {
                        if (!i.pIx.bSg()) {
                            bRw = d.bRw();
                            elapsedRealtime = (SystemClock.elapsedRealtime() - bRw) / 1000;
                            if ((bRw == -1 || elapsedRealtime >= ((long) a.pGU) || b.bRF()) && b.bRE()) {
                                x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
                                taVar.cey.data = Integer.valueOf(17);
                            } else {
                                x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                                taVar.cey.data = Integer.valueOf(16);
                            }
                            i.pIx.b(new WeakReference(taVar.cex.activity));
                            break;
                        }
                        x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
                        i.pIx.jM(false);
                        i.pIx.jN(false);
                        taVar.cey.data = Integer.valueOf(18);
                        break;
                    }
                    x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                    i.pIx.jM(false);
                    i.pIx.jN(false);
                    taVar.cey.data = Integer.valueOf(16);
                    break;
                }
                x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                taVar.cey.data = Integer.valueOf(16);
                break;
                break;
            case 2:
                taVar.cey.data = Boolean.valueOf(e.bRE());
                break;
            case 3:
                taVar.cey.data = Boolean.valueOf(b.bRF());
                break;
            case 4:
                i.pIx.bSh();
                break;
        }
        taVar.cex.activity = null;
        return false;
    }
}

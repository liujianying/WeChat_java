package com.tencent.mm.plugin.walletlock.b;

import android.content.Intent;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends com.tencent.mm.sdk.b.c<qz> {
    public c() {
        this.sFo = qz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qz qzVar = (qz) bVar;
        if (qzVar != null) {
            Intent intent = qzVar.cbL.cbN;
            int intExtra = intent.getIntExtra("key_wallet_lock_type", -1);
            if (qzVar.cbL.bOb != null) {
                x.i("MicroMsg.StartWalletLockUIListener", "alvinluo startWalletLockUI type: %d", new Object[]{Integer.valueOf(intExtra)});
                if (intExtra == 2) {
                    intent.setClass(qzVar.cbL.bOb, FingerprintWalletLockUI.class);
                } else if (intExtra == 1) {
                    intent.setClass(qzVar.cbL.bOb, GestureGuardLogicUI.class);
                }
                qzVar.cbL.bOb.startActivityForResult(intent, qzVar.cbL.bRZ);
                qzVar.cbM.bLW = true;
            } else {
                qzVar.cbM.bLW = false;
            }
            x.i("MicroMsg.StartWalletLockUIListener", "alvinluo isSuccess: %b", new Object[]{Boolean.valueOf(qzVar.cbM.bLW)});
        }
        return false;
    }
}

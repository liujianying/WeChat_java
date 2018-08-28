package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.g.a.pm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class WalletOfflineCoinPurseUI$36 extends c<pm> {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$36(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
        this.sFo = pm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!this.lMe.isFinishing()) {
            this.lMe.finish();
        }
        return false;
    }
}

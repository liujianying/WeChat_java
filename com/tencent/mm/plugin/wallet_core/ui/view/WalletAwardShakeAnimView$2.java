package com.tencent.mm.plugin.wallet_core.ui.view;

import com.tencent.mm.pluginsdk.i.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WalletAwardShakeAnimView$2 extends a {
    final /* synthetic */ WalletAwardShakeAnimView pzP;

    WalletAwardShakeAnimView$2(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        this.pzP = walletAwardShakeAnimView;
    }

    public final void biM() {
        x.i("MicroMsg.WalletAwardShakeAnimView", "onShake");
        long bI = bi.bI(WalletAwardShakeAnimView.b(this.pzP));
        if (WalletAwardShakeAnimView.c(this.pzP)) {
            if (bI < 80) {
                return;
            }
        } else if (bI < 1200) {
            return;
        }
        WalletAwardShakeAnimView.a(this.pzP, bi.VG());
        WalletAwardShakeAnimView.d(this.pzP);
        if (!WalletAwardShakeAnimView.e(this.pzP)) {
            WalletAwardShakeAnimView.f(this.pzP);
            WalletAwardShakeAnimView.g(this.pzP);
        }
    }

    public final void onRelease() {
    }
}

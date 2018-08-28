package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WalletBindCardResultUI$5 implements OnClickListener {
    final /* synthetic */ WalletBindCardResultUI ptz;

    WalletBindCardResultUI$5(WalletBindCardResultUI walletBindCardResultUI) {
        this.ptz = walletBindCardResultUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletBindCardResultUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[]{WalletBindCardResultUI.c(this.ptz), WalletBindCardResultUI.d(this.ptz), Integer.valueOf(WalletBindCardResultUI.e(this.ptz))});
        this.ptz.gP(2);
        qu quVar = new qu();
        quVar.cbq.userName = WalletBindCardResultUI.c(this.ptz);
        quVar.cbq.cbs = bi.aG(WalletBindCardResultUI.d(this.ptz), "");
        quVar.cbq.scene = 1034;
        quVar.cbq.cbt = 0;
        if (WalletBindCardResultUI.e(this.ptz) > 0) {
            quVar.cbq.cbu = WalletBindCardResultUI.e(this.ptz);
        }
        a.sFg.m(quVar);
        if (bi.oW(WalletBindCardResultUI.f(this.ptz).pmO.poL) || WalletBindCardResultUI.f(this.ptz).pmM.pji <= 0) {
            WalletBindCardResultUI.a(this.ptz, false);
        } else {
            WalletBindCardResultUI.a(this.ptz, true);
        }
    }
}

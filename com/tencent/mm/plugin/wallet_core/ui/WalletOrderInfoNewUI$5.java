package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoNewUI$5 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoNewUI pwh;
    final /* synthetic */ Commodity pwj;

    WalletOrderInfoNewUI$5(WalletOrderInfoNewUI walletOrderInfoNewUI, Commodity commodity) {
        this.pwh = walletOrderInfoNewUI;
        this.pwj = commodity;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletOrderInfoNewUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[]{WalletOrderInfoNewUI.m(this.pwh), WalletOrderInfoNewUI.n(this.pwh), Integer.valueOf(WalletOrderInfoNewUI.q(this.pwh))});
        qu quVar = new qu();
        quVar.cbq.userName = WalletOrderInfoNewUI.m(this.pwh);
        quVar.cbq.cbs = bi.aG(WalletOrderInfoNewUI.n(this.pwh), "");
        quVar.cbq.scene = 1034;
        quVar.cbq.cbt = 0;
        if (WalletOrderInfoNewUI.q(this.pwh) > 0) {
            quVar.cbq.cbu = WalletOrderInfoNewUI.q(this.pwh);
        }
        quVar.cbq.context = this.pwh;
        a.sFg.m(quVar);
        WalletOrderInfoNewUI walletOrderInfoNewUI = this.pwh;
        boolean z = !bi.oW(this.pwj.ppD.poL) && this.pwj.ppD.pqc > 0;
        WalletOrderInfoNewUI.a(walletOrderInfoNewUI, z);
        if (WalletOrderInfoNewUI.o(this.pwh)) {
            h.mEJ.h(14118, new Object[]{WalletOrderInfoNewUI.l(this.pwh), this.pwh.bNs(), Integer.valueOf(3)});
        } else {
            h.mEJ.h(14118, new Object[]{WalletOrderInfoNewUI.l(this.pwh), this.pwh.bNs(), Integer.valueOf(1)});
        }
    }
}

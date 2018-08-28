package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoNewUI$2 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoNewUI pwh;
    final /* synthetic */ ShowInfo pwi;

    WalletOrderInfoNewUI$2(WalletOrderInfoNewUI walletOrderInfoNewUI, ShowInfo showInfo) {
        this.pwh = walletOrderInfoNewUI;
        this.pwi = showInfo;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletOrderInfoNewUI", "onClick jump tinyApp, linkWeApp:%s, linkAddr:%s", new Object[]{this.pwi.pqm, this.pwi.pqn});
        qu quVar = new qu();
        quVar.cbq.userName = this.pwi.pqm;
        quVar.cbq.cbs = bi.aG(this.pwi.pqn, "");
        quVar.cbq.scene = 1060;
        quVar.cbq.bGG = WalletOrderInfoNewUI.l(this.pwh);
        quVar.cbq.cbt = 0;
        quVar.cbq.context = this.pwh;
        a.sFg.m(quVar);
    }
}

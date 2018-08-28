package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.3;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.e;

class WalletBalanceManagerUI$3$2 implements d {
    final /* synthetic */ 3 paA;

    WalletBalanceManagerUI$3$2(3 3) {
        this.paA = 3;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        a aVar = (a) this.paA.jLK.get(menuItem.getItemId());
        if (aVar.paB == 1) {
            e.l(this.paA.pax.mController.tml, aVar.paC, false);
        } else if (aVar.paB == 2) {
            qu quVar = new qu();
            quVar.cbq.userName = aVar.paD;
            quVar.cbq.cbs = bi.aG(aVar.paE, "");
            quVar.cbq.scene = 1061;
            quVar.cbq.cbt = 0;
            com.tencent.mm.sdk.b.a.sFg.m(quVar);
        } else if (aVar.paB == 7) {
            Intent intent = new Intent();
            com.tencent.mm.bg.d.A(this.paA.pax.mController.tml, "wallet_ecard", ".ui.WalletECardLogoutUI");
        }
    }
}

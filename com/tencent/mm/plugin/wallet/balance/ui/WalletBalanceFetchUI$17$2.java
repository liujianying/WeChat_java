package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.17;
import com.tencent.mm.plugin.wallet_core.model.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.e;

class WalletBalanceFetchUI$17$2 implements d {
    final /* synthetic */ 17 pam;

    WalletBalanceFetchUI$17$2(17 17) {
        this.pam = 17;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int itemId = menuItem.getItemId();
        if (this.pam.pal.plE.plG != null && itemId < this.pam.pal.plE.plG.length) {
            c cVar = this.pam.pal.plE.plG[itemId];
            x.i("MicroMsg.WalletBalanceFetchUI", "jump type: %s, url: %s", new Object[]{Integer.valueOf(cVar.paB), cVar.hwI});
            switch (cVar.paB) {
                case 1:
                    e.l(this.pam.pad.mController.tml, cVar.hwI, true);
                    return;
                default:
                    return;
            }
        }
    }
}

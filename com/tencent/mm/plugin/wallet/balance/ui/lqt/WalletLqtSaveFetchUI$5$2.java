package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.5;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.e;

class WalletLqtSaveFetchUI$5$2 implements d {
    final /* synthetic */ 5 pce;

    WalletLqtSaveFetchUI$5$2(5 5) {
        this.pce = 5;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int itemId = menuItem.getItemId();
        if (itemId < this.pce.pcd.size()) {
            e.l(this.pce.pcc, ((String) this.pce.pcd.get(itemId)).split("\\|\\|")[1], false);
        }
    }
}

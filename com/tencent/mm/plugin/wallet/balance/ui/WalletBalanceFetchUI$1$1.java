package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.1;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

class WalletBalanceFetchUI$1$1 implements d {
    final /* synthetic */ List pae;
    final /* synthetic */ 1 paf;

    WalletBalanceFetchUI$1$1(1 1, List list) {
        this.paf = 1;
        this.pae = list;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (i < this.pae.size()) {
            WalletBalanceFetchUI.a(this.paf.pad, (Bankcard) this.pae.get(i));
            x.i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", new Object[]{WalletBalanceFetchUI.a(this.paf.pad).field_desc});
        } else {
            x.i("MicroMsg.WalletBalanceFetchUI", "add new card");
            WalletBalanceFetchUI.a(this.paf.pad, null);
            WalletBalanceFetchUI.b(this.paf.pad);
        }
        WalletBalanceFetchUI.c(this.paf.pad);
    }
}

package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.wallet_core.ui.e;

class WalletBalanceManagerUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ WalletBalanceManagerUI pax;

    WalletBalanceManagerUI$4(WalletBalanceManagerUI walletBalanceManagerUI) {
        this.pax = walletBalanceManagerUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.pax.paw.plY);
        intent.putExtra("showShare", false);
        intent.putExtra("geta8key_username", q.GF());
        intent.putExtra("KPublisherId", "pay_blance_list");
        intent.putExtra("geta8key_scene", 33);
        d.b(this.pax, "webview", ".ui.tools.WebViewUI", intent);
        e.He(16);
        return true;
    }
}

package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bg.d;

class RechargeUI$18 implements OnMenuItemClickListener {
    final /* synthetic */ RechargeUI mqE;

    RechargeUI$18(RechargeUI rechargeUI) {
        this.mqE = rechargeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", RechargeUI.j(this.mqE));
        d.b(this.mqE, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }
}

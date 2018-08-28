package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RegByMobileSetNickUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ RegByMobileSetNickUI eVt;

    RegByMobileSetNickUI$2(RegByMobileSetNickUI regByMobileSetNickUI) {
        this.eVt = regByMobileSetNickUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eVt.YC();
        this.eVt.finish();
        return true;
    }
}

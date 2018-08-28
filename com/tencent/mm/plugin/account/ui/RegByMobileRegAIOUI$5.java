package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RegByMobileRegAIOUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ RegByMobileRegAIOUI eVb;

    RegByMobileRegAIOUI$5(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.eVb = regByMobileRegAIOUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eVb.YC();
        RegByMobileRegAIOUI.k(this.eVb);
        this.eVb.finish();
        return true;
    }
}

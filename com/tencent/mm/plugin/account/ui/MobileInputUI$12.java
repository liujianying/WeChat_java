package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MobileInputUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ MobileInputUI eTe;

    MobileInputUI$12(MobileInputUI mobileInputUI) {
        this.eTe = mobileInputUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        MobileInputUI.b(this.eTe);
        return true;
    }
}

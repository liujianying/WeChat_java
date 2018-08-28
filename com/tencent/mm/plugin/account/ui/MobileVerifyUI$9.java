package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MobileVerifyUI$9 implements OnMenuItemClickListener {
    final /* synthetic */ MobileVerifyUI eUo;

    MobileVerifyUI$9(MobileVerifyUI mobileVerifyUI) {
        this.eUo = mobileVerifyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        MobileVerifyUI.i(this.eUo);
        return true;
    }
}

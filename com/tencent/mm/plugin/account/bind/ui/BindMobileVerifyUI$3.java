package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BindMobileVerifyUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ BindMobileVerifyUI eHl;

    BindMobileVerifyUI$3(BindMobileVerifyUI bindMobileVerifyUI) {
        this.eHl = bindMobileVerifyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eHl.finish();
        return true;
    }
}

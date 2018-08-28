package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BindQQUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ BindQQUI eHn;

    BindQQUI$4(BindQQUI bindQQUI) {
        this.eHn = bindQQUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eHn.YC();
        this.eHn.finish();
        return true;
    }
}

package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RegByQQAuthUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ RegByQQAuthUI eWg;

    RegByQQAuthUI$2(RegByQQAuthUI regByQQAuthUI) {
        this.eWg = regByQQAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eWg.YC();
        this.eWg.finish();
        return true;
    }
}

package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BindGoogleContactUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BindGoogleContactUI eFm;

    BindGoogleContactUI$1(BindGoogleContactUI bindGoogleContactUI) {
        this.eFm = bindGoogleContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eFm.finish();
        return true;
    }
}

package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ComposeUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$4(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ComposeUI.k(this.mfs).onClick(null);
        return false;
    }
}

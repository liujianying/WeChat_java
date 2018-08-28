package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MoreShareAppUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ MoreShareAppUI uAO;

    MoreShareAppUI$2(MoreShareAppUI moreShareAppUI) {
        this.uAO = moreShareAppUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.uAO.finish();
        return true;
    }
}

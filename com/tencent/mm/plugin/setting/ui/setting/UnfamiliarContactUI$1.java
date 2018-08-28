package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class UnfamiliarContactUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ UnfamiliarContactUI mVx;

    UnfamiliarContactUI$1(UnfamiliarContactUI unfamiliarContactUI) {
        this.mVx = unfamiliarContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mVx.finish();
        return true;
    }
}

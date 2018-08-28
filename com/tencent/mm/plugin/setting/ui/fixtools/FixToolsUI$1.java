package com.tencent.mm.plugin.setting.ui.fixtools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FixToolsUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FixToolsUI mPn;

    FixToolsUI$1(FixToolsUI fixToolsUI) {
        this.mPn = fixToolsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mPn.finish();
        return true;
    }
}

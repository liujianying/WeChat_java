package com.tencent.mm.plugin.setting.ui.fixtools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FixToolsUplogUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ FixToolsUplogUI mPy;

    FixToolsUplogUI$4(FixToolsUplogUI fixToolsUplogUI) {
        this.mPy = fixToolsUplogUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mPy.finish();
        return true;
    }
}

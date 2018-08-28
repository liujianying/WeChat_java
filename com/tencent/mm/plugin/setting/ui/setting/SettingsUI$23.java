package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsUI$23 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$23(SettingsUI settingsUI) {
        this.mUx = settingsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mUx.finish();
        return true;
    }
}

package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsModifyUserAuthUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsModifyUserAuthUI mSY;

    SettingsModifyUserAuthUI$1(SettingsModifyUserAuthUI settingsModifyUserAuthUI) {
        this.mSY = settingsModifyUserAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mSY.finish();
        return true;
    }
}

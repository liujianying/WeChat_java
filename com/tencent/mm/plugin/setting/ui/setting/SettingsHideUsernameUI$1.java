package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsHideUsernameUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsHideUsernameUI mSm;

    SettingsHideUsernameUI$1(SettingsHideUsernameUI settingsHideUsernameUI) {
        this.mSm = settingsHideUsernameUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mSm.finish();
        return true;
    }
}

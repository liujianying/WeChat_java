package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsAccountInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAccountInfoUI mRC;

    SettingsAccountInfoUI$1(SettingsAccountInfoUI settingsAccountInfoUI) {
        this.mRC = settingsAccountInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mRC.YC();
        this.mRC.finish();
        return true;
    }
}

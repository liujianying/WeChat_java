package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsAboutSystemUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAboutSystemUI mRk;

    SettingsAboutSystemUI$1(SettingsAboutSystemUI settingsAboutSystemUI) {
        this.mRk = settingsAboutSystemUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mRk.YC();
        this.mRk.finish();
        return true;
    }
}

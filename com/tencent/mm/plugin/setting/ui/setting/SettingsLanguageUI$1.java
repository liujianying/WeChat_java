package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsLanguageUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsLanguageUI mSr;

    SettingsLanguageUI$1(SettingsLanguageUI settingsLanguageUI) {
        this.mSr = settingsLanguageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mSr.YC();
        this.mSr.finish();
        return true;
    }
}

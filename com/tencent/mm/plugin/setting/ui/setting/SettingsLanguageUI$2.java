package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsLanguageUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsLanguageUI mSr;

    SettingsLanguageUI$2(SettingsLanguageUI settingsLanguageUI) {
        this.mSr = settingsLanguageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mSr.finish();
        SettingsLanguageUI.a(this.mSr, SettingsLanguageUI.a(this.mSr), SettingsLanguageUI.b(this.mSr));
        return true;
    }
}

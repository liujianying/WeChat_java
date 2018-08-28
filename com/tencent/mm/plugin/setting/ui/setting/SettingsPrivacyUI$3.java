package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsPrivacyUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsPrivacyUI mTv;

    SettingsPrivacyUI$3(SettingsPrivacyUI settingsPrivacyUI) {
        this.mTv = settingsPrivacyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mTv.YC();
        this.mTv.finish();
        return true;
    }
}

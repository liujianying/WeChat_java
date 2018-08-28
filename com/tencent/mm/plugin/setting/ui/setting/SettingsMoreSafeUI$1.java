package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsMoreSafeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsMoreSafeUI mTc;

    SettingsMoreSafeUI$1(SettingsMoreSafeUI settingsMoreSafeUI) {
        this.mTc = settingsMoreSafeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mTc.YC();
        this.mTc.finish();
        return true;
    }
}

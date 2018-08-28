package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsPersonalMoreUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsPersonalMoreUI mTi;

    SettingsPersonalMoreUI$2(SettingsPersonalMoreUI settingsPersonalMoreUI) {
        this.mTi = settingsPersonalMoreUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mTi.YC();
        this.mTi.finish();
        return true;
    }
}

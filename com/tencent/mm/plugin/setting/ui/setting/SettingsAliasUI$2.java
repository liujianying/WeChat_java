package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsAliasUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAliasUI mRV;

    SettingsAliasUI$2(SettingsAliasUI settingsAliasUI) {
        this.mRV = settingsAliasUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mRV.YC();
        this.mRV.finish();
        return true;
    }
}

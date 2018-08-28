package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsModifyNameUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsModifyNameUI mSW;

    SettingsModifyNameUI$4(SettingsModifyNameUI settingsModifyNameUI) {
        this.mSW = settingsModifyNameUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mSW.YC();
        this.mSW.finish();
        return true;
    }
}

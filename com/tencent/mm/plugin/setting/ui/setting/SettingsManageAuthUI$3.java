package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsManageAuthUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsManageAuthUI mSw;

    SettingsManageAuthUI$3(SettingsManageAuthUI settingsManageAuthUI) {
        this.mSw = settingsManageAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mSw.finish();
        return true;
    }
}

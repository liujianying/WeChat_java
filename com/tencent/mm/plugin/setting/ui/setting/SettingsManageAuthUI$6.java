package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsManageAuthUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsManageAuthUI mSw;

    SettingsManageAuthUI$6(SettingsManageAuthUI settingsManageAuthUI) {
        this.mSw = settingsManageAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == 700) {
            SettingsManageAuthUI.a(this.mSw, true);
            SettingsManageAuthUI.d(this.mSw).notifyDataSetChanged();
            SettingsManageAuthUI.e(this.mSw);
        }
        return true;
    }
}

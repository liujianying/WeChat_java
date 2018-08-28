package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsSearchAuthUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsSearchAuthUI mTJ;

    SettingsSearchAuthUI$6(SettingsSearchAuthUI settingsSearchAuthUI) {
        this.mTJ = settingsSearchAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == 700) {
            SettingsSearchAuthUI.a(this.mTJ, false);
            SettingsSearchAuthUI.g(this.mTJ).notifyDataSetChanged();
            SettingsSearchAuthUI.e(this.mTJ);
        }
        return true;
    }
}

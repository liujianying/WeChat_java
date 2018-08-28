package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsNotificationUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsNotificationUI mTf;

    SettingsNotificationUI$1(SettingsNotificationUI settingsNotificationUI) {
        this.mTf = settingsNotificationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mTf.YC();
        this.mTf.finish();
        return true;
    }
}

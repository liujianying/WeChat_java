package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsPluginsNotifyUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsPluginsNotifyUI mTj;

    SettingsPluginsNotifyUI$1(SettingsPluginsNotifyUI settingsPluginsNotifyUI) {
        this.mTj = settingsPluginsNotifyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mTj.YC();
        this.mTj.finish();
        return true;
    }
}

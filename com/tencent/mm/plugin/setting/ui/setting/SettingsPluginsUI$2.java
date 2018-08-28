package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsPluginsUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsPluginsUI mTo;

    SettingsPluginsUI$2(SettingsPluginsUI settingsPluginsUI) {
        this.mTo = settingsPluginsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mTo.YC();
        this.mTo.finish();
        return true;
    }
}

package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsNetStatUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsNetStatUI mTe;

    SettingsNetStatUI$2(SettingsNetStatUI settingsNetStatUI) {
        this.mTe = settingsNetStatUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SettingsNetStatUI.a(this.mTe);
        return true;
    }
}

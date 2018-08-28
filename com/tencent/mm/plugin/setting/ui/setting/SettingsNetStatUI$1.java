package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsNetStatUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsNetStatUI mTe;

    SettingsNetStatUI$1(SettingsNetStatUI settingsNetStatUI) {
        this.mTe = settingsNetStatUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mTe.YC();
        this.mTe.finish();
        return true;
    }
}

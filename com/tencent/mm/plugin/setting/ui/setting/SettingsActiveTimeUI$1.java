package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsActiveTimeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsActiveTimeUI mRJ;

    SettingsActiveTimeUI$1(SettingsActiveTimeUI settingsActiveTimeUI) {
        this.mRJ = settingsActiveTimeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mRJ.YC();
        this.mRJ.finish();
        return true;
    }
}

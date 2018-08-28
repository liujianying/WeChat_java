package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsRingtoneUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsRingtoneUI mTC;

    SettingsRingtoneUI$1(SettingsRingtoneUI settingsRingtoneUI) {
        this.mTC = settingsRingtoneUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mTC.YC();
        this.mTC.finish();
        return true;
    }
}

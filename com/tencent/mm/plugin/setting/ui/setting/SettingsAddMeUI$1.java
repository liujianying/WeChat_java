package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsAddMeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAddMeUI mRL;

    SettingsAddMeUI$1(SettingsAddMeUI settingsAddMeUI) {
        this.mRL = settingsAddMeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mRL.YC();
        this.mRL.finish();
        return true;
    }
}

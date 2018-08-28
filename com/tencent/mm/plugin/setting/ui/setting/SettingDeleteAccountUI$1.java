package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingDeleteAccountUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingDeleteAccountUI mQN;

    SettingDeleteAccountUI$1(SettingDeleteAccountUI settingDeleteAccountUI) {
        this.mQN = settingDeleteAccountUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mQN.YC();
        this.mQN.finish();
        return true;
    }
}

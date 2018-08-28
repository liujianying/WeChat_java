package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsModifyEmailAddrUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsModifyEmailAddrUI mSQ;

    SettingsModifyEmailAddrUI$1(SettingsModifyEmailAddrUI settingsModifyEmailAddrUI) {
        this.mSQ = settingsModifyEmailAddrUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SettingsModifyEmailAddrUI.a(this.mSQ);
        return true;
    }
}

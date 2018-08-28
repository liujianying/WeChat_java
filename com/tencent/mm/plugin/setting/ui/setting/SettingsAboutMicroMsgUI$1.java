package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsAboutMicroMsgUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAboutMicroMsgUI mRb;

    SettingsAboutMicroMsgUI$1(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        this.mRb = settingsAboutMicroMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mRb.YC();
        this.mRb.finish();
        return true;
    }
}

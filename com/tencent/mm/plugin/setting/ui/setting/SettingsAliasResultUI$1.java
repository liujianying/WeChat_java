package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsAliasResultUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAliasResultUI mRQ;

    SettingsAliasResultUI$1(SettingsAliasResultUI settingsAliasResultUI) {
        this.mRQ = settingsAliasResultUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mRQ.finish();
        return true;
    }
}

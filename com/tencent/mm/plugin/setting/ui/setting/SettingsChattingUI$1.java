package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsChattingUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsChattingUI mSa;

    SettingsChattingUI$1(SettingsChattingUI settingsChattingUI) {
        this.mSa = settingsChattingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mSa.YC();
        this.mSa.finish();
        return true;
    }
}

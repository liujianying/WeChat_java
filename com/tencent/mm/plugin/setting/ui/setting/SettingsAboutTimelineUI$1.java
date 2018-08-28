package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsAboutTimelineUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAboutTimelineUI mRw;

    SettingsAboutTimelineUI$1(SettingsAboutTimelineUI settingsAboutTimelineUI) {
        this.mRw = settingsAboutTimelineUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mRw.YC();
        this.mRw.finish();
        return true;
    }
}

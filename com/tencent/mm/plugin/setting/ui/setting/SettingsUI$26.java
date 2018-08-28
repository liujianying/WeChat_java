package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

class SettingsUI$26 implements d {
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$26(SettingsUI settingsUI) {
        this.mUx = settingsUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                SettingsUI.d(this.mUx);
                return;
            case 2:
                SettingsUI.e(this.mUx);
                return;
            default:
                return;
        }
    }
}

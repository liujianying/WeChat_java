package com.tencent.mm.plugin.voiceprint.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsVoicePrintUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsVoicePrintUI oGa;

    SettingsVoicePrintUI$3(SettingsVoicePrintUI settingsVoicePrintUI) {
        this.oGa = settingsVoicePrintUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.oGa.finish();
        return true;
    }
}

package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;

class SettingsPanel$5 implements OnClickListener {
    final /* synthetic */ SettingsPanel gQR;

    SettingsPanel$5(SettingsPanel settingsPanel) {
        this.gQR = settingsPanel;
    }

    public final void onClick(View view) {
        if (SettingsPanel.d(this.gQR) != null) {
            SettingsPanel.d(this.gQR).onClick(view);
        }
    }
}

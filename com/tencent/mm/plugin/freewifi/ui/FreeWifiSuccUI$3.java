package com.tencent.mm.plugin.freewifi.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class FreeWifiSuccUI$3 implements OnCheckedChangeListener {
    final /* synthetic */ FreeWifiSuccUI jol;

    FreeWifiSuccUI$3(FreeWifiSuccUI freeWifiSuccUI) {
        this.jol = freeWifiSuccUI;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            FreeWifiSuccUI.a(this.jol, true);
        } else {
            FreeWifiSuccUI.a(this.jol, false);
        }
    }
}

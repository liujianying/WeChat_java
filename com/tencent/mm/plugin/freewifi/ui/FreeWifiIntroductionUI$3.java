package com.tencent.mm.plugin.freewifi.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class FreeWifiIntroductionUI$3 implements OnCheckedChangeListener {
    final /* synthetic */ FreeWifiIntroductionUI jnu;

    FreeWifiIntroductionUI$3(FreeWifiIntroductionUI freeWifiIntroductionUI) {
        this.jnu = freeWifiIntroductionUI;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            FreeWifiIntroductionUI.a(this.jnu).setEnabled(true);
        } else {
            FreeWifiIntroductionUI.a(this.jnu).setEnabled(false);
        }
    }
}

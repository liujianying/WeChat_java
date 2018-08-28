package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.g.a.ro;
import com.tencent.mm.sdk.b.a;

class SettingsPersonalInfoUI$4 implements Runnable {
    final /* synthetic */ SettingsPersonalInfoUI mTh;

    SettingsPersonalInfoUI$4(SettingsPersonalInfoUI settingsPersonalInfoUI) {
        this.mTh = settingsPersonalInfoUI;
    }

    public final void run() {
        ro roVar = new ro();
        roVar.ccs.ccu = true;
        a.sFg.m(roVar);
    }
}

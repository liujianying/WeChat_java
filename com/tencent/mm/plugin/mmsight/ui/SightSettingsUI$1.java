package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.x;

class SightSettingsUI$1 implements Runnable {
    final /* synthetic */ SightSettingsUI lqC;

    SightSettingsUI$1(SightSettingsUI sightSettingsUI) {
        this.lqC = sightSettingsUI;
    }

    public final void run() {
        x.i("MicroMsg.SightSettingsUI", "has connect");
        SightSettingsUI.a(this.lqC);
    }
}

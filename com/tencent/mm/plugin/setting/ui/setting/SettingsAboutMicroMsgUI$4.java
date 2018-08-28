package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.sdk.platformtools.al.a;

class SettingsAboutMicroMsgUI$4 implements a {
    final /* synthetic */ SettingsAboutMicroMsgUI mRb;
    final /* synthetic */ r mRf;

    SettingsAboutMicroMsgUI$4(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI, r rVar) {
        this.mRb = settingsAboutMicroMsgUI;
        this.mRf = rVar;
    }

    public final boolean vD() {
        g.DF().c(this.mRf);
        g.DF().b(255, SettingsAboutMicroMsgUI.c(this.mRb));
        SettingsAboutMicroMsgUI.d(this.mRb);
        if (SettingsAboutMicroMsgUI.e(this.mRb) != null) {
            SettingsAboutMicroMsgUI.e(this.mRb).SO();
            SettingsAboutMicroMsgUI.f(this.mRb);
        }
        if (SettingsAboutMicroMsgUI.a(this.mRb) != null) {
            SettingsAboutMicroMsgUI.a(this.mRb).cancel();
        }
        SettingsAboutMicroMsgUI.g(this.mRb);
        return false;
    }
}

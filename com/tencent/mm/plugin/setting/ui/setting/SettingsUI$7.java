package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.sdk.platformtools.al.a;

class SettingsUI$7 implements a {
    final /* synthetic */ ac mRd;
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$7(SettingsUI settingsUI, ac acVar) {
        this.mUx = settingsUI;
        this.mRd = acVar;
    }

    public final boolean vD() {
        g.DF().c(this.mRd);
        g.DF().b(281, SettingsUI.l(this.mUx));
        SettingsUI.m(this.mUx);
        if (SettingsUI.n(this.mUx) != null) {
            SettingsUI.n(this.mUx).SO();
            SettingsUI.o(this.mUx);
        }
        if (SettingsUI.p(this.mUx) != null) {
            SettingsUI.p(this.mUx).dismiss();
        }
        SettingsUI.q(this.mUx);
        return false;
    }
}

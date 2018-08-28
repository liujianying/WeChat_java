package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.sdk.platformtools.al.a;

class SettingsUI$10 implements a {
    final /* synthetic */ r mRf;
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$10(SettingsUI settingsUI, r rVar) {
        this.mUx = settingsUI;
        this.mRf = rVar;
    }

    public final boolean vD() {
        g.DF().c(this.mRf);
        g.DF().b(255, SettingsUI.r(this.mUx));
        SettingsUI.s(this.mUx);
        if (SettingsUI.t(this.mUx) != null) {
            SettingsUI.t(this.mUx).SO();
            SettingsUI.u(this.mUx);
        }
        if (SettingsUI.p(this.mUx) != null) {
            SettingsUI.p(this.mUx).cancel();
        }
        SettingsUI.v(this.mUx);
        return false;
    }
}

package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;

class SettingsUI$6 implements e {
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$6(SettingsUI settingsUI) {
        this.mUx = settingsUI;
    }

    public final void a(int i, int i2, String str, l lVar) {
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
    }
}

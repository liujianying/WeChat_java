package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;

class SettingsUI$14 implements e {
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$14(SettingsUI settingsUI) {
        this.mUx = settingsUI;
    }

    public final void a(int i, int i2, String str, l lVar) {
        ah.A(new Runnable() {
            public final void run() {
                g.DF().b(281, SettingsUI.w(SettingsUI$14.this.mUx));
                SettingsUI.x(SettingsUI$14.this.mUx);
            }
        });
    }
}

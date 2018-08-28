package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class SettingsUI$20 implements e {
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$20(SettingsUI settingsUI) {
        this.mUx = settingsUI;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.SettingsUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + lVar.getType());
        ah.A(new 1(this, lVar, i2, i));
    }
}

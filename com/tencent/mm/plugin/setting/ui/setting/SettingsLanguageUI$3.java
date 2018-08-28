package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;

class SettingsLanguageUI$3 implements a {
    final /* synthetic */ SettingsLanguageUI mSr;

    SettingsLanguageUI$3(SettingsLanguageUI settingsLanguageUI) {
        this.mSr = settingsLanguageUI;
    }

    public final void a(e eVar) {
        if (eVar != null) {
            c Lr = eVar.Lr();
            byte[] bArr = new byte[0];
            g.Eg();
            Lr.x(bArr, com.tencent.mm.kernel.a.Df());
        }
    }
}

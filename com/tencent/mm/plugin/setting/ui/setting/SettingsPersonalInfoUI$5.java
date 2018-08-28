package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.aa.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class SettingsPersonalInfoUI$5 implements Runnable {
    final /* synthetic */ SettingsPersonalInfoUI mTh;

    SettingsPersonalInfoUI$5(SettingsPersonalInfoUI settingsPersonalInfoUI) {
        this.mTh = settingsPersonalInfoUI;
    }

    public final void run() {
        x.d("MicroMsg.SettingsPersonalInfoUI", "updateHeadImg hasUin:%b user:%s", new Object[]{Boolean.valueOf(g.Eg().Dx()), q.GF()});
        if (g.Eg().Dx()) {
            at.dBv.iy(c.A(q.GF(), true));
        }
        SettingsPersonalInfoUI.a(this.mTh);
        if (SettingsPersonalInfoUI.b(this.mTh)) {
            h.mEJ.h(11002, new Object[]{Integer.valueOf(4), Integer.valueOf(4)});
        }
    }
}

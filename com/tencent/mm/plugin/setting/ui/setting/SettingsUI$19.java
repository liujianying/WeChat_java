package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bt;
import com.tencent.mm.sdk.platformtools.ah;

class SettingsUI$19 implements e {
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$19(SettingsUI settingsUI) {
        this.mUx = settingsUI;
    }

    public final void a(int i, int i2, String str, l lVar) {
        String I = at.dBv.I("login_weixin_username", "");
        if (bt.dDs.iM(I)) {
            bt.dDs.l(I, "last_logout_no_pwd_ticket", "");
        }
        ah.A(new 1(this));
    }
}

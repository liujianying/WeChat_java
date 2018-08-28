package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.2;
import com.tencent.mm.sdk.platformtools.al.a;

class SettingsAboutMicroMsgUI$2$2 implements a {
    final /* synthetic */ 2 mRc;
    final /* synthetic */ ac mRd;

    SettingsAboutMicroMsgUI$2$2(2 2, ac acVar) {
        this.mRc = 2;
        this.mRd = acVar;
    }

    public final boolean vD() {
        g.DF().c(this.mRd);
        g.DF().b(281, 2.a(this.mRc));
        2.b(this.mRc);
        if (2.c(this.mRc) != null) {
            2.c(this.mRc).SO();
            2.d(this.mRc);
        }
        if (SettingsAboutMicroMsgUI.a(this.mRc.mRb) != null) {
            SettingsAboutMicroMsgUI.a(this.mRc.mRb).dismiss();
        }
        SettingsAboutMicroMsgUI.b(this.mRc.mRb);
        return false;
    }
}

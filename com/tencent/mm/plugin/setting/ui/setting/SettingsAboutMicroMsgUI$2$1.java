package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.2;

class SettingsAboutMicroMsgUI$2$1 implements e {
    final /* synthetic */ 2 mRc;

    SettingsAboutMicroMsgUI$2$1(2 2) {
        this.mRc = 2;
    }

    public final void a(int i, int i2, String str, l lVar) {
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
    }
}

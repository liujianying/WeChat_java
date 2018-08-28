package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.2;

class SettingsAboutSystemUI$2$1 implements Runnable {
    final /* synthetic */ int mRn;
    final /* synthetic */ 2 mRo;

    SettingsAboutSystemUI$2$1(2 2, int i) {
        this.mRo = 2;
        this.mRn = i;
    }

    public final void run() {
        ((Dialog) this.mRo.mRl.getTag()).dismiss();
        g.Ei().DT().set(327686, Integer.valueOf(this.mRn));
        g.Ei().DT().lm(true);
        SettingsAboutSystemUI.f(this.mRo.mRk);
    }
}

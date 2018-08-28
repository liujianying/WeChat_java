package com.tencent.mm.plugin.shake.ui;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;

class TVInfoUI$6 implements d {
    final /* synthetic */ TVInfoUI nbD;

    TVInfoUI$6(TVInfoUI tVInfoUI) {
        this.nbD = tVInfoUI;
    }

    public final void bx(int i, int i2) {
        switch (i2) {
            case -1:
                h.a(this.nbD.mController.tml, this.nbD.mController.tml.getString(R.l.app_delete_tips), null, null, this.nbD.mController.tml.getString(R.l.app_delete), new 1(this));
                return;
            case 0:
                TVInfoUI.b(this.nbD);
                return;
            case 1:
                TVInfoUI.c(this.nbD);
                return;
            case 2:
                TVInfoUI.d(this.nbD);
                return;
            default:
                return;
        }
    }
}

package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.12;
import com.tencent.mm.sdk.platformtools.bi;

class ExdeviceRankInfoUI$12$3 implements Runnable {
    final /* synthetic */ 12 iFH;

    ExdeviceRankInfoUI$12$3(12 12) {
        this.iFH = 12;
    }

    public final void run() {
        ExdeviceRankInfoUI.h(this.iFH.iFG);
        if (!bi.oW(ExdeviceRankInfoUI.i(this.iFH.iFG))) {
            this.iFH.iFG.addIconOptionMenu(0, R.k.actionbar_icon_dark_more, new 1(this));
        }
        if (ExdeviceRankInfoUI.k(this.iFH.iFG) != null) {
            ExdeviceRankInfoUI.k(this.iFH.iFG).Av(ExdeviceRankInfoUI.l(this.iFH.iFG));
        }
    }
}

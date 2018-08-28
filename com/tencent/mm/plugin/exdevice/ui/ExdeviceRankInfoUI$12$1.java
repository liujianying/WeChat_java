package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.12;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceRankInfoUI$12$1 implements Runnable {
    final /* synthetic */ 12 iFH;

    ExdeviceRankInfoUI$12$1(12 12) {
        this.iFH = 12;
    }

    public final void run() {
        if (ExdeviceRankInfoUI.e(this.iFH.iFG) != null && ExdeviceRankInfoUI.e(this.iFH.iFG).isShowing()) {
            ExdeviceRankInfoUI.e(this.iFH.iFG).dismiss();
            ExdeviceRankInfoUI.f(this.iFH.iFG);
            x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
        }
    }
}

package com.tencent.mm.plugin.hce.ui;

import com.tencent.mm.sdk.platformtools.x;
import java.util.TimerTask;

class HCETransparentUI$1 extends TimerTask {
    final /* synthetic */ HCETransparentUI kjt;

    HCETransparentUI$1(HCETransparentUI hCETransparentUI) {
        this.kjt = hCETransparentUI;
    }

    public final void run() {
        x.i("MicroMsg.HCETransparentUI", "alvinluo loop check NFC switch currentCount: %d", new Object[]{Integer.valueOf(HCETransparentUI.a(this.kjt))});
        HCETransparentUI.b(this.kjt);
        this.kjt.runOnUiThread(new 1(this));
    }
}

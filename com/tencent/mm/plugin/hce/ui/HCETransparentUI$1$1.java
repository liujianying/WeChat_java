package com.tencent.mm.plugin.hce.ui;

import com.tencent.mm.plugin.hce.a.b;
import com.tencent.mm.plugin.hce.ui.HCETransparentUI.1;
import com.tencent.mm.sdk.platformtools.x;

class HCETransparentUI$1$1 implements Runnable {
    final /* synthetic */ 1 kju;

    HCETransparentUI$1$1(1 1) {
        this.kju = 1;
    }

    public final void run() {
        if (HCETransparentUI.a(this.kju.kjt) > 10) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo loop check count exceed max limit: %d", new Object[]{Integer.valueOf(10)});
            HCETransparentUI.c(this.kju.kjt);
            HCETransparentUI.d(this.kju.kjt);
        } else if (b.aVX()) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo loopCheck NFC switch is opened, and cancel task");
            HCETransparentUI.c(this.kju.kjt);
            HCETransparentUI.e(this.kju.kjt);
        }
    }
}

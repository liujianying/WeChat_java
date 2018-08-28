package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.platformtools.x;

class FingerPrintAuthTransparentUI$11 implements a {
    final /* synthetic */ FingerPrintAuthTransparentUI jhl;

    FingerPrintAuthTransparentUI$11(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        this.jhl = fingerPrintAuthTransparentUI;
    }

    public final void af(int i, String str) {
        this.jhl.dO(false);
        if (i == 0) {
            x.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
            FingerPrintAuthTransparentUI.d(this.jhl);
            FingerPrintAuthTransparentUI.a(this.jhl, false);
            return;
        }
        FingerPrintAuthTransparentUI.a(this.jhl, str);
    }
}

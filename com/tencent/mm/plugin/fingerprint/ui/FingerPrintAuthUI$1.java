package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.pluginsdk.wallet.a;

class FingerPrintAuthUI$1 implements a {
    final /* synthetic */ FingerPrintAuthUI jhs;

    FingerPrintAuthUI$1(FingerPrintAuthUI fingerPrintAuthUI) {
        this.jhs = fingerPrintAuthUI;
    }

    public final void af(int i, String str) {
        this.jhs.dO(false);
        if (i == 0) {
            FingerPrintAuthUI.b(this.jhs);
            if (FingerPrintAuthUI.c(this.jhs)) {
                FingerPrintAuthUI.a(this.jhs, false);
                return;
            }
            return;
        }
        FingerPrintAuthUI.a(this.jhs, str, i);
    }
}

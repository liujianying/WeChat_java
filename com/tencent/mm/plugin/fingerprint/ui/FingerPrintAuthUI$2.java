package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.wallet_core.ui.g;

class FingerPrintAuthUI$2 implements Runnable {
    final /* synthetic */ FingerPrintAuthUI jhs;
    final /* synthetic */ boolean jht;

    FingerPrintAuthUI$2(FingerPrintAuthUI fingerPrintAuthUI, boolean z) {
        this.jhs = fingerPrintAuthUI;
        this.jht = z;
    }

    public final void run() {
        if (this.jht) {
            FingerPrintAuthUI.a(this.jhs, g.b(this.jhs, false, null));
        } else if (FingerPrintAuthUI.d(this.jhs) != null && FingerPrintAuthUI.d(this.jhs).isShowing()) {
            FingerPrintAuthUI.d(this.jhs).dismiss();
            FingerPrintAuthUI.a(this.jhs, null);
        }
    }
}

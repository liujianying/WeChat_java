package com.tencent.mm.plugin.fingerprint.ui;

class FingerPrintAuthUI$3 implements Runnable {
    final /* synthetic */ FingerPrintAuthUI jhs;

    FingerPrintAuthUI$3(FingerPrintAuthUI fingerPrintAuthUI) {
        this.jhs = fingerPrintAuthUI;
    }

    public final void run() {
        FingerPrintAuthUI.e(this.jhs).setVisibility(0);
    }
}

package com.tencent.mm.plugin.fingerprint.ui;

import android.widget.TextView;

class FingerPrintAuthTransparentUI$6 implements Runnable {
    final /* synthetic */ TextView hNx;
    final /* synthetic */ FingerPrintAuthTransparentUI jhl;

    FingerPrintAuthTransparentUI$6(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI, TextView textView) {
        this.jhl = fingerPrintAuthTransparentUI;
        this.hNx = textView;
    }

    public final void run() {
        this.hNx.setVisibility(0);
    }
}

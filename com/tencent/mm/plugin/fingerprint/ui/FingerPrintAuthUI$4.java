package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class FingerPrintAuthUI$4 implements Runnable {
    final /* synthetic */ int bFr;
    final /* synthetic */ String dho;
    final /* synthetic */ FingerPrintAuthUI jhs;

    FingerPrintAuthUI$4(FingerPrintAuthUI fingerPrintAuthUI, String str, int i) {
        this.jhs = fingerPrintAuthUI;
        this.dho = str;
        this.bFr = i;
    }

    public final void run() {
        h.a(this.jhs, this.dho, "", this.jhs.getString(i.wallet_i_know_it), false, new 1(this));
    }
}

package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.wallet_core.a;

class FingerPrintAuthUI$5 implements OnClickListener {
    final /* synthetic */ FingerPrintAuthUI jhs;

    FingerPrintAuthUI$5(FingerPrintAuthUI fingerPrintAuthUI) {
        this.jhs = fingerPrintAuthUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.c(this.jhs, new Bundle(), -1);
    }
}

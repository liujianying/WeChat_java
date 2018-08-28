package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class FingerPrintAuthTransparentUI$5 implements OnClickListener {
    final /* synthetic */ FingerPrintAuthTransparentUI jhl;

    FingerPrintAuthTransparentUI$5(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        this.jhl = fingerPrintAuthTransparentUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.jhl.finish();
    }
}

package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class FingerPrintAuthTransparentUI$13 implements OnCancelListener {
    final /* synthetic */ FingerPrintAuthTransparentUI jhl;

    FingerPrintAuthTransparentUI$13(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        this.jhl = fingerPrintAuthTransparentUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        FingerPrintAuthTransparentUI.aNM();
        this.jhl.finish();
    }
}

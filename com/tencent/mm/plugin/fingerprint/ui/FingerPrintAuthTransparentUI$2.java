package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class FingerPrintAuthTransparentUI$2 implements OnClickListener {
    final /* synthetic */ FingerPrintAuthTransparentUI jhl;

    FingerPrintAuthTransparentUI$2(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        this.jhl = fingerPrintAuthTransparentUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        x.i("MicroMsg.FingerPrintAuthTransparentUI", "showSuccessAlert, finish ui!");
        this.jhl.finish();
    }
}

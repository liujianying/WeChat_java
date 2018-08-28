package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;

class FingerPrintAuthTransparentUI$10 implements OnClickListener {
    final /* synthetic */ FingerPrintAuthTransparentUI jhl;
    final /* synthetic */ CheckBox jhm;

    FingerPrintAuthTransparentUI$10(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI, CheckBox checkBox) {
        this.jhl = fingerPrintAuthTransparentUI;
        this.jhm = checkBox;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FingerPrintAuthTransparentUI.b(this.jhl, this.jhm.isChecked());
    }
}

package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class FingerPrintEntranceUI$4 implements OnClickListener {
    final /* synthetic */ FingerPrintEntranceUI jhw;

    FingerPrintEntranceUI$4(FingerPrintEntranceUI fingerPrintEntranceUI) {
        this.jhw = fingerPrintEntranceUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.jhw.finish();
    }
}

package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class BaseScanUI$5 implements OnClickListener {
    final /* synthetic */ BaseScanUI mHS;

    BaseScanUI$5(BaseScanUI baseScanUI) {
        this.mHS = baseScanUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        BaseScanUI.b(this.mHS, true);
        BaseScanUI.u(this.mHS);
        BaseScanUI.v(this.mHS);
        this.mHS.overridePendingTransition(0, 0);
    }
}

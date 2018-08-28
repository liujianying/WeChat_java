package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class BaseScanUI$17 implements OnClickListener {
    final /* synthetic */ BaseScanUI mHS;

    BaseScanUI$17(BaseScanUI baseScanUI) {
        this.mHS = baseScanUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        BaseScanUI.j(this.mHS);
        this.mHS.finish();
    }
}

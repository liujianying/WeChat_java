package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.f.b;

class BaseScanUI$15 implements OnClickListener {
    final /* synthetic */ BaseScanUI mHS;

    BaseScanUI$15(BaseScanUI baseScanUI) {
        this.mHS = baseScanUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.bu(this.mHS);
        this.mHS.finish();
    }
}

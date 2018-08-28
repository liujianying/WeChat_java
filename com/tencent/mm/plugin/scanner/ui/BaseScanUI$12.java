package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;

class BaseScanUI$12 implements OnClickListener {
    final /* synthetic */ BaseScanUI mHS;

    BaseScanUI$12(BaseScanUI baseScanUI) {
        this.mHS = baseScanUI;
    }

    public final void onClick(View view) {
        BaseScanUI.i(this.mHS);
    }
}

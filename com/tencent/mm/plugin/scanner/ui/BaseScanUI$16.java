package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class BaseScanUI$16 implements OnClickListener {
    final /* synthetic */ BaseScanUI mHS;

    BaseScanUI$16(BaseScanUI baseScanUI) {
        this.mHS = baseScanUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mHS.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        BaseScanUI.j(this.mHS);
        this.mHS.finish();
    }
}

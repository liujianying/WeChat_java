package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class AppInstallerUI$5 implements OnClickListener {
    final /* synthetic */ AppInstallerUI sDq;

    AppInstallerUI$5(AppInstallerUI appInstallerUI) {
        this.sDq = appInstallerUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.a(405, 75, 1, true);
        if (AppInstallerUI.e(this.sDq) != null && !AppInstallerUI.e(this.sDq).isShowing()) {
            AppInstallerUI.e(this.sDq).show();
        }
    }
}

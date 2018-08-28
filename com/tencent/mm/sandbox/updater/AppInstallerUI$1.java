package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class AppInstallerUI$1 implements OnCancelListener {
    final /* synthetic */ AppInstallerUI sDq;

    AppInstallerUI$1(AppInstallerUI appInstallerUI) {
        this.sDq = appInstallerUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        AppInstallerUI.a(this.sDq);
    }
}

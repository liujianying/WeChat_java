package com.tencent.mm.sandbox.updater;

import com.tencent.mm.sdk.platformtools.bi;

class AppInstallerUI$3 implements Runnable {
    final /* synthetic */ AppInstallerUI sDq;
    final /* synthetic */ String sDr;

    AppInstallerUI$3(AppInstallerUI appInstallerUI, String str) {
        this.sDq = appInstallerUI;
        this.sDr = str;
    }

    public final void run() {
        this.sDq.startActivity(bi.WI(this.sDr));
        AppInstallerUI.d(this.sDq);
    }
}

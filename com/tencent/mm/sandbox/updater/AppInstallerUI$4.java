package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.updater.j.a;
import com.tencent.mm.sdk.platformtools.x;

class AppInstallerUI$4 implements OnClickListener {
    final /* synthetic */ AppInstallerUI sDq;

    AppInstallerUI$4(AppInstallerUI appInstallerUI) {
        this.sDq = appInstallerUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.AppInstallerUI", "install dialog had been canceled");
        if (AppInstallerUI.e(this.sDq) != null && AppInstallerUI.e(this.sDq).isShowing()) {
            AppInstallerUI.e(this.sDq).dismiss();
        }
        a.sER.ai(2, true);
        if (AppInstallerUI.b(this.sDq) == 2) {
            i.ai(this.sDq, 4);
        }
        h.mEJ.a(405, 74, 1, true);
        i.chb();
        AppInstallerUI.d(this.sDq);
    }
}

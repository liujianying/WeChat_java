package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sandbox.updater.j.a;
import com.tencent.mm.sdk.platformtools.x;

class AppInstallerUI$2 implements OnClickListener {
    final /* synthetic */ AppInstallerUI sDq;

    AppInstallerUI$2(AppInstallerUI appInstallerUI) {
        this.sDq = appInstallerUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
        if (AppInstallerUI.b(this.sDq) == 2) {
            i.ai(this.sDq, 3);
        }
        String Hw = c.Hw(AppInstallerUI.c(this.sDq));
        x.d("MicroMsg.AppInstallerUI", Hw);
        if (Hw != null) {
            a.sER.ai(1, true);
            h.mEJ.a(405, 72, 1, true);
            AppInstallerUI.a(this.sDq, Hw);
            return;
        }
        h.mEJ.a(405, 73, 1, true);
        x.e("MicroMsg.AppInstallerUI", "pack not found!");
        com.tencent.mm.ui.base.h.bA(this.sDq, this.sDq.getString(R.l.update_err_pack_not_found));
        i.chg();
        this.sDq.finish();
    }
}

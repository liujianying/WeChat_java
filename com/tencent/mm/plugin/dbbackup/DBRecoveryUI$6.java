package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.ui.widget.a.c;

class DBRecoveryUI$6 implements Runnable {
    final /* synthetic */ c eHI;
    final /* synthetic */ DBRecoveryUI hZJ;

    DBRecoveryUI$6(DBRecoveryUI dBRecoveryUI, c cVar) {
        this.hZJ = dBRecoveryUI;
        this.eHI = cVar;
    }

    public final void run() {
        this.eHI.dismiss();
        this.hZJ.finish();
        d.aCG();
    }
}

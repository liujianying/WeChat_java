package com.tencent.mm.plugin.dbbackup;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class DBRecoveryUI$1 implements OnClickListener {
    final /* synthetic */ DBRecoveryUI hZJ;

    DBRecoveryUI$1(DBRecoveryUI dBRecoveryUI) {
        this.hZJ = dBRecoveryUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (DBRecoveryUI.a(this.hZJ) != 0) {
            DBRecoveryUI.b(this.hZJ).setVisibility(0);
            DBRecoveryUI.c(this.hZJ).setVisibility(8);
            return;
        }
        d.aCG();
    }
}

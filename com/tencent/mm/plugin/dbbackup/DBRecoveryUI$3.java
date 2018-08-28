package com.tencent.mm.plugin.dbbackup;

import android.view.View;
import android.view.View.OnClickListener;

class DBRecoveryUI$3 implements OnClickListener {
    final /* synthetic */ DBRecoveryUI hZJ;

    DBRecoveryUI$3(DBRecoveryUI dBRecoveryUI) {
        this.hZJ = dBRecoveryUI;
    }

    public final void onClick(View view) {
        DBRecoveryUI.d(this.hZJ).setEnabled(false);
        DBRecoveryUI.f(this.hZJ);
    }
}

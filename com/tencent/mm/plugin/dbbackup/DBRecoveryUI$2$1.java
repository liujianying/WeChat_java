package com.tencent.mm.plugin.dbbackup;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.dbbackup.DBRecoveryUI.2;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.ui.base.h;

class DBRecoveryUI$2$1 implements OnClickListener {
    final /* synthetic */ 2 hZK;

    DBRecoveryUI$2$1(2 2) {
        this.hZK = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        f.mDy.a(873, 25, 1, false);
        if (g.Ei().DP() == null) {
            h.i(this.hZK.hZJ, R.l.data_recovery_no_data, 0);
            return;
        }
        DBRecoveryUI.b(this.hZK.hZJ).setVisibility(8);
        DBRecoveryUI.c(this.hZK.hZJ).setVisibility(0);
        DBRecoveryUI.d(this.hZK.hZJ).setEnabled(true);
        DBRecoveryUI.e(this.hZK.hZJ);
    }
}

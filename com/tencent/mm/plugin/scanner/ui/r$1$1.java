package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.ui.r.1;

class r$1$1 implements OnCancelListener {
    final /* synthetic */ 1 mMC;

    r$1$1(1 1) {
        this.mMC = 1;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.mMC.mMB.mMA);
        this.mMC.mMB.jnR = null;
    }
}

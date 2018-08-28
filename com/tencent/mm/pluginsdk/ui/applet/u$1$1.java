package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.ui.applet.u.1;

class u$1$1 implements OnCancelListener {
    final /* synthetic */ 1 qJR;

    u$1$1(1 1) {
        this.qJR = 1;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.qJR.qJQ.mMA);
        this.qJR.qJQ.jnR = null;
    }
}

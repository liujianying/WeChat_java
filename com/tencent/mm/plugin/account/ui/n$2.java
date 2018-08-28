package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.x;

class n$2 implements OnCancelListener {
    final /* synthetic */ x eGH;
    final /* synthetic */ n eTL;

    n$2(n nVar, x xVar) {
        this.eTL = nVar;
        this.eGH = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eGH);
        g.DF().b(132, this.eTL);
    }
}

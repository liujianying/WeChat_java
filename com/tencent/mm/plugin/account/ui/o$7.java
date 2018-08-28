package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

class o$7 implements OnCancelListener {
    final /* synthetic */ s eTB;
    final /* synthetic */ o eTO;

    o$7(o oVar, s sVar) {
        this.eTO = oVar;
        this.eTB = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eTB);
        g.DF().b(126, this.eTO);
    }
}

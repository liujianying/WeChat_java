package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;

class o$1 implements OnCancelListener {
    final /* synthetic */ a eRM;
    final /* synthetic */ o eTO;

    o$1(o oVar, a aVar) {
        this.eTO = oVar;
        this.eRM = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eRM);
        g.DF().b(145, this.eTO);
    }
}

package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;

class o$12 implements OnCancelListener {
    final /* synthetic */ r eRC;
    final /* synthetic */ o eTO;

    o$12(o oVar, r rVar) {
        this.eTO = oVar;
        this.eRC = rVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eRC);
    }
}

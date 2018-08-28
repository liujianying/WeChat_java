package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.r;

class t$9 implements OnCancelListener {
    final /* synthetic */ t nNL;
    final /* synthetic */ r nNQ;

    t$9(t tVar, r rVar) {
        this.nNL = tVar;
        this.nNQ = rVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.Ek();
        g.Eh().dpP.c(this.nNQ);
    }
}

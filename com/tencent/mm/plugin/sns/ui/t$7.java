package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.r;

class t$7 implements OnCancelListener {
    final /* synthetic */ t nNL;
    final /* synthetic */ r nNP;

    t$7(t tVar, r rVar) {
        this.nNL = tVar;
        this.nNP = rVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.nNL.hcA != 0) {
            g.Ek();
            g.Eh().dpP.c(this.nNP);
            this.nNL.hcA = 0;
        }
    }
}

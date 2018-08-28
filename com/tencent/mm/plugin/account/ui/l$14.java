package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;

class l$14 implements OnCancelListener {
    final /* synthetic */ q eQM;
    final /* synthetic */ l eSI;

    l$14(l lVar, q qVar) {
        this.eSI = lVar;
        this.eQM = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eQM);
    }
}

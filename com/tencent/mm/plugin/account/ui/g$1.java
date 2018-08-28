package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;

class g$1 implements OnCancelListener {
    final /* synthetic */ q eQM;
    final /* synthetic */ g eSt;

    g$1(g gVar, q qVar) {
        this.eSt = gVar;
        this.eQM = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eQM);
    }
}

package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;

class SimpleLoginUI$5 implements OnCancelListener {
    final /* synthetic */ q eQM;
    final /* synthetic */ SimpleLoginUI eXn;

    SimpleLoginUI$5(SimpleLoginUI simpleLoginUI, q qVar) {
        this.eXn = simpleLoginUI;
        this.eQM = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eQM);
    }
}

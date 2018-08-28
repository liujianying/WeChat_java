package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.17;

class MobileLoginOrForceReg$17$1 implements OnCancelListener {
    final /* synthetic */ q eQM;
    final /* synthetic */ 17 eTF;

    MobileLoginOrForceReg$17$1(17 17, q qVar) {
        this.eTF = 17;
        this.eQM = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eQM);
    }
}

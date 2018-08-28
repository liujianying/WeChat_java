package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.2;

class MobileLoginOrForceReg$2$1 implements OnCancelListener {
    final /* synthetic */ s eTB;
    final /* synthetic */ 2 eTC;

    MobileLoginOrForceReg$2$1(2 2, s sVar) {
        this.eTC = 2;
        this.eTB = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eTB);
    }
}

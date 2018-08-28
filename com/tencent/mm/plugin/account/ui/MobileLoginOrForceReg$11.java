package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

class MobileLoginOrForceReg$11 implements OnCancelListener {
    final /* synthetic */ s eTB;
    final /* synthetic */ MobileLoginOrForceReg eTx;

    MobileLoginOrForceReg$11(MobileLoginOrForceReg mobileLoginOrForceReg, s sVar) {
        this.eTx = mobileLoginOrForceReg;
        this.eTB = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eTB);
    }
}

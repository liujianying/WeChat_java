package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class MobileLoginOrForceReg$18 implements OnDismissListener {
    final /* synthetic */ MobileLoginOrForceReg eTx;

    MobileLoginOrForceReg$18(MobileLoginOrForceReg mobileLoginOrForceReg) {
        this.eTx = mobileLoginOrForceReg;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        MobileLoginOrForceReg.q(this.eTx);
    }
}

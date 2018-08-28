package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class WalletPayDeductUI$2 implements a {
    final /* synthetic */ WalletPayDeductUI pgf;

    WalletPayDeductUI$2(WalletPayDeductUI walletPayDeductUI) {
        this.pgf = walletPayDeductUI;
    }

    public final void cf(boolean z) {
        int i = 2;
        this.pgf.jn(z);
        if (this.pgf.mCZ != null) {
            h hVar = h.mEJ;
            Object[] objArr = new Object[2];
            if (z) {
                i = 1;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = this.pgf.mCZ.bOd;
            hVar.h(15379, objArr);
        }
    }
}

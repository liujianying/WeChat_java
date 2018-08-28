package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI.3;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.base.h.a;

class WalletPayDeductUI$3$1 implements a {
    final /* synthetic */ 3 pgh;

    WalletPayDeductUI$3$1(3 3) {
        this.pgh = 3;
    }

    public final void vh(int i) {
        WalletPayDeductUI.a(this.pgh.pgf, (Bankcard) this.pgh.pgg.get(i));
        WalletPayDeductUI.c(this.pgh.pgf);
    }
}

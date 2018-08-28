package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet_core.c.b.a;

public class WalletPayUBalanceManagerUI extends WalletBalanceManagerUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void bMV() {
        boolean z;
        p.bNp();
        if (p.bNq().paw == null) {
            z = true;
        } else {
            z = false;
        }
        a(new a(), z, false);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0 && (lVar instanceof a)) {
            aL();
        }
        return false;
    }

    protected final void bMW() {
        L(WalletPayUBalanceSaveUI.class);
    }
}

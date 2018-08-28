package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI;
import com.tencent.mm.plugin.wallet_payu.balance.a.a;
import com.tencent.mm.pluginsdk.wallet.h;

public class WalletPayUBalanceSaveUI extends WalletBalanceSaveUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oZK.setVisibility(8);
    }

    protected final void bNa() {
        a(new a(this.myQ, "ZAR"), true, true);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0 && (lVar instanceof a)) {
            h.a(this, ((a) lVar).bOd, "", 11, 1);
        }
        return false;
    }
}

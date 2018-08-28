package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.ui.e;

class WalletBalanceManagerUI$2 implements OnClickListener {
    final /* synthetic */ WalletBalanceManagerUI pax;
    final /* synthetic */ ag pay;

    WalletBalanceManagerUI$2(WalletBalanceManagerUI walletBalanceManagerUI, ag agVar) {
        this.pax = walletBalanceManagerUI;
        this.pay = agVar;
    }

    public final void onClick(View view) {
        g.Ek();
        g.Ei().DT().a(a.sXO, Integer.valueOf(-1));
        e.l(this.pax, this.pay.bPA(), true);
    }
}

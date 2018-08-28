package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;

class WalletBalanceManagerUI$8 implements OnClickListener {
    final /* synthetic */ WalletBalanceManagerUI pax;

    WalletBalanceManagerUI$8(WalletBalanceManagerUI walletBalanceManagerUI) {
        this.pax = walletBalanceManagerUI;
    }

    public final void onClick(View view) {
        p.bNp();
        ArrayList bPF = p.bNq().bPF();
        if (bPF == null || bPF.size() == 0) {
            x.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is empty, do bind card to fetch");
            WalletBalanceManagerUI.b(this.pax);
            return;
        }
        x.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is valid, to do fetch");
        a.a(this.pax, b.class, null, null);
        e.He(15);
    }
}

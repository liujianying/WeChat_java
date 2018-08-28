package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class WalletBalanceManagerUI$13 implements OnClickListener {
    final /* synthetic */ WalletBalanceManagerUI pax;

    WalletBalanceManagerUI$13(WalletBalanceManagerUI walletBalanceManagerUI) {
        this.pax = walletBalanceManagerUI;
    }

    public final void onClick(View view) {
        p.bNp();
        ag bNq = p.bNq();
        String str = bNq.prA != null ? bNq.prA.field_lqt_cell_lqt_open_url : null;
        if (!bi.oW(str)) {
            e.l(this.pax, str, true);
        }
    }
}

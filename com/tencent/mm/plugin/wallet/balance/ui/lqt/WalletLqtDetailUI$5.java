package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class WalletLqtDetailUI$5 implements a {
    final /* synthetic */ WalletLqtDetailUI pbs;

    WalletLqtDetailUI$5(WalletLqtDetailUI walletLqtDetailUI) {
        this.pbs = walletLqtDetailUI;
    }

    public final void bd(Object obj) {
        if (WalletLqtDetailUI.a(this.pbs) != null) {
            WalletLqtDetailUI.a(this.pbs).dismiss();
        }
        x.i("MicroMsg.WalletLqtDetailUI", "close account failed: %s", new Object[]{obj});
        if (obj != null) {
            CharSequence obj2;
            if (obj instanceof String) {
                obj2 = obj.toString();
            } else {
                obj2 = this.pbs.getString(i.wallet_lqt_network_error);
            }
            Toast.makeText(this.pbs, obj2, 1).show();
        }
    }
}

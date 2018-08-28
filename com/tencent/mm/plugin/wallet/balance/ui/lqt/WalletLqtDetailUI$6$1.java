package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.Toast;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.6;
import com.tencent.mm.plugin.wxpay.a.i;

class WalletLqtDetailUI$6$1 implements Runnable {
    final /* synthetic */ 6 pbv;

    WalletLqtDetailUI$6$1(6 6) {
        this.pbv = 6;
    }

    public final void run() {
        if (WalletLqtDetailUI.a(this.pbv.pbs) != null) {
            WalletLqtDetailUI.a(this.pbv.pbs).dismiss();
        }
        Toast.makeText(this.pbv.pbs, this.pbv.pbs.getString(i.wallet_lqt_close_account_finish), 1).show();
        this.pbv.pbs.finish();
    }
}

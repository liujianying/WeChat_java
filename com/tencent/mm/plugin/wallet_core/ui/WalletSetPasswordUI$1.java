package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletSetPasswordUI$1 implements OnClickListener {
    final /* synthetic */ WalletSetPasswordUI pys;

    WalletSetPasswordUI$1(WalletSetPasswordUI walletSetPasswordUI) {
        this.pys = walletSetPasswordUI;
    }

    public final void onClick(View view) {
        if (this.pys.bND()) {
            this.pys.YC();
            this.pys.showDialog(1000);
            return;
        }
        this.pys.finish();
    }
}

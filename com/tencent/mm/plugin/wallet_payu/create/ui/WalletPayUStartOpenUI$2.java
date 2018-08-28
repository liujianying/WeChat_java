package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletPayUStartOpenUI$2 implements OnClickListener {
    final /* synthetic */ WalletPayUStartOpenUI pES;

    WalletPayUStartOpenUI$2(WalletPayUStartOpenUI walletPayUStartOpenUI) {
        this.pES = walletPayUStartOpenUI;
    }

    public final void onClick(View view) {
        if (WalletPayUStartOpenUI.b(this.pES).getVisibility() == 0) {
            this.pES.sy.putString("key_mobile", WalletPayUStartOpenUI.c(this.pES));
            this.pES.sy.putString("dial_code", WalletPayUStartOpenUI.d(this.pES));
        }
        this.pES.cDL().m(new Object[0]);
    }
}

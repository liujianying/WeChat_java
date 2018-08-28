package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;

class WalletPayUPayUI$2 implements OnClickListener {
    final /* synthetic */ WalletPayUPayUI pFA;

    WalletPayUPayUI$2(WalletPayUPayUI walletPayUPayUI) {
        this.pFA = walletPayUPayUI;
    }

    public final void onClick(View view) {
        WalletPayUPayUI.a(this.pFA, (FavorPayInfo) view.getTag());
        if (WalletPayUPayUI.a(this.pFA) != null) {
            WalletPayUPayUI.b(this.pFA).pnT = "";
        }
        WalletPayUPayUI.c(this.pFA, "");
        WalletPayUPayUI.c(this.pFA).dismiss();
        WalletPayUPayUI.d(this.pFA);
        WalletPayUPayUI.e(this.pFA);
    }
}

package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.s;

class WalletBalanceSaveUI$1 implements OnClickListener {
    final /* synthetic */ WalletBalanceSaveUI paK;

    WalletBalanceSaveUI$1(WalletBalanceSaveUI walletBalanceSaveUI) {
        this.paK = walletBalanceSaveUI;
    }

    public final void onClick(View view) {
        this.paK.myQ = bi.getDouble(this.paK.hXD.getText(), 0.0d);
        if (this.paK.myQ <= 0.0d || !this.paK.hXD.ZF()) {
            s.makeText(this.paK.mController.tml, i.wallet_balance_save_input_invalid, 0).show();
        } else {
            this.paK.bNa();
        }
    }
}

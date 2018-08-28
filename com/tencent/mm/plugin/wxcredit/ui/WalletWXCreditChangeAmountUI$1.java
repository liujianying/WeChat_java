package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletWXCreditChangeAmountUI$1 implements OnClickListener {
    final /* synthetic */ WalletWXCreditChangeAmountUI qxj;

    WalletWXCreditChangeAmountUI$1(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        this.qxj = walletWXCreditChangeAmountUI;
    }

    public final void onClick(View view) {
        WalletWXCreditChangeAmountUI.a(this.qxj, true);
        WalletWXCreditChangeAmountUI.a(this.qxj);
        this.qxj.showDialog(1);
    }
}

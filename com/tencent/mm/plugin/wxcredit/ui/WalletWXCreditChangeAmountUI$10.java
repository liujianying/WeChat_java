package com.tencent.mm.plugin.wxcredit.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletWXCreditChangeAmountUI$10 implements OnClickListener {
    final /* synthetic */ WalletWXCreditChangeAmountUI qxj;

    WalletWXCreditChangeAmountUI$10(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        this.qxj = walletWXCreditChangeAmountUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.qxj.showVKB();
    }
}

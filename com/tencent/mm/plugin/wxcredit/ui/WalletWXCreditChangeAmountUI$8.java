package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class WalletWXCreditChangeAmountUI$8 implements OnItemClickListener {
    final /* synthetic */ WalletWXCreditChangeAmountUI qxj;

    WalletWXCreditChangeAmountUI$8(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        this.qxj = walletWXCreditChangeAmountUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.qxj.dismissDialog(2);
        if (WalletWXCreditChangeAmountUI.l(this.qxj)) {
            if (i == 0) {
                WalletWXCreditChangeAmountUI.c(this.qxj).kQE = "Y";
            } else {
                WalletWXCreditChangeAmountUI.c(this.qxj).kQE = "N";
            }
        } else if (i == 0) {
            WalletWXCreditChangeAmountUI.f(this.qxj).kQE = "Y";
        } else {
            WalletWXCreditChangeAmountUI.f(this.qxj).kQE = "N";
        }
        WalletWXCreditChangeAmountUI.k(this.qxj);
    }
}

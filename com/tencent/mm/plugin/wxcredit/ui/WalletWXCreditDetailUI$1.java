package com.tencent.mm.plugin.wxcredit.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wxcredit.a.i;

class WalletWXCreditDetailUI$1 implements OnClickListener {
    final /* synthetic */ WalletWXCreditDetailUI qxp;

    WalletWXCreditDetailUI$1(WalletWXCreditDetailUI walletWXCreditDetailUI) {
        this.qxp = walletWXCreditDetailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.qxp.cDP().a(new i(WalletWXCreditDetailUI.a(this.qxp).field_bankcardType, WalletWXCreditDetailUI.a(this.qxp).plR), true, 1);
    }
}

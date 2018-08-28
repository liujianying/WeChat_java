package com.tencent.mm.plugin.wxcredit.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;

class WalletWXCreditChangeAmountUI$3 implements OnClickListener {
    final /* synthetic */ WalletWXCreditChangeAmountUI qxj;

    WalletWXCreditChangeAmountUI$3(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        this.qxj = walletWXCreditChangeAmountUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c af = a.af(this.qxj);
        if (af != null) {
            af.b(this.qxj, this.qxj.sy);
        } else {
            this.qxj.finish();
        }
    }
}

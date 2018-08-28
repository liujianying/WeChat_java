package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.List;

class WalletWXCreditChangeAmountUI$6 implements OnClickListener {
    final /* synthetic */ WalletWXCreditChangeAmountUI qxj;

    WalletWXCreditChangeAmountUI$6(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        this.qxj = walletWXCreditChangeAmountUI;
    }

    public final void onClick(View view) {
        if (WalletWXCreditChangeAmountUI.b(this.qxj)) {
            if (WalletWXCreditChangeAmountUI.c(this.qxj).qwK == null) {
                WalletWXCreditChangeAmountUI.c(this.qxj).kQE = WalletWXCreditChangeAmountUI.e(this.qxj).getText().toString();
            } else if (WalletWXCreditChangeAmountUI.d(this.qxj).getVisibility() == 0) {
                WalletWXCreditChangeAmountUI.c(this.qxj).qwK.kQE = WalletWXCreditChangeAmountUI.d(this.qxj).getText().toString();
            }
            if (WalletWXCreditChangeAmountUI.f(this.qxj).qwK == null) {
                WalletWXCreditChangeAmountUI.f(this.qxj).kQE = WalletWXCreditChangeAmountUI.h(this.qxj).getText().toString();
            } else if (WalletWXCreditChangeAmountUI.g(this.qxj).getVisibility() == 0) {
                WalletWXCreditChangeAmountUI.f(this.qxj).qwK.kQE = WalletWXCreditChangeAmountUI.g(this.qxj).getText().toString();
            }
            List arrayList = new ArrayList();
            arrayList.add(WalletWXCreditChangeAmountUI.c(this.qxj));
            arrayList.add(WalletWXCreditChangeAmountUI.f(this.qxj));
            String string = this.qxj.sy.getString("kreq_token");
            this.qxj.sy.getString("key_bank_type");
            this.qxj.a(new c(arrayList, string), true, false);
            return;
        }
        s.makeText(this.qxj.mController.tml, i.wallet_wxcredit_qustion_input_err, 0).show();
    }
}

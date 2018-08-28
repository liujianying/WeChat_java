package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class WalletRealNameVerifyUI$6 implements OnClickListener {
    final /* synthetic */ WalletRealNameVerifyUI pkE;

    WalletRealNameVerifyUI$6(WalletRealNameVerifyUI walletRealNameVerifyUI) {
        this.pkE = walletRealNameVerifyUI;
    }

    public final void onClick(View view) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(this.pkE.getString(a$i.wallet_card_aggreement_user));
        linkedList2.add(Integer.valueOf(0));
        if (WalletRealNameVerifyUI.e(this.pkE) != null && WalletRealNameVerifyUI.e(this.pkE).pnL) {
            linkedList.add(this.pkE.getString(a$i.wallet_card_aggreement_bank));
            linkedList2.add(Integer.valueOf(1));
        }
        h.a(this.pkE, "", linkedList, linkedList2, "", new 1(this));
    }
}

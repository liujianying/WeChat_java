package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class WalletCardImportUI$5 implements OnClickListener {
    final /* synthetic */ WalletCardImportUI puv;

    WalletCardImportUI$5(WalletCardImportUI walletCardImportUI) {
        this.puv = walletCardImportUI;
    }

    public final void onClick(View view) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(this.puv.getString(i.wallet_card_aggreement_user));
        linkedList2.add(Integer.valueOf(0));
        if (WalletCardImportUI.c(this.puv) != null && WalletCardImportUI.c(this.puv).pnL) {
            linkedList.add(this.puv.getString(i.wallet_card_aggreement_bank));
            linkedList2.add(Integer.valueOf(1));
        }
        h.a(this.puv, "", linkedList, linkedList2, "", new 1(this));
    }
}

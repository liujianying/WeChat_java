package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.a;

class WalletBindDepositUI$1 implements OnClickListener {
    final /* synthetic */ WalletBindDepositUI qwM;

    WalletBindDepositUI$1(WalletBindDepositUI walletBindDepositUI) {
        this.qwM = walletBindDepositUI;
    }

    public final void onClick(View view) {
        if (!bi.oW(WalletBindDepositUI.a(this.qwM).getText())) {
            if (WalletBindDepositUI.b(this.qwM)) {
                this.qwM.cDL().s(new Object[]{r0});
                WalletBindDepositUI.c(this.qwM);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("key_support_bankcard", 1);
            bundle.putString("key_bank_type", WalletBindDepositUI.d(this.qwM).lMV);
            bundle.putInt("key_bankcard_type", 1);
            a.af(this.qwM).a(this.qwM, WalletCardSelectUI.class, bundle, 1);
        }
    }
}

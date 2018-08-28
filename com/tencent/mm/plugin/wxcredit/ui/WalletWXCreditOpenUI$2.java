package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.wallet_core.ui.e;

class WalletWXCreditOpenUI$2 implements OnClickListener {
    final /* synthetic */ WalletWXCreditOpenUI qxy;

    WalletWXCreditOpenUI$2(WalletWXCreditOpenUI walletWXCreditOpenUI) {
        this.qxy = walletWXCreditOpenUI;
    }

    public final void onClick(View view) {
        e.a(this.qxy, WalletWXCreditOpenUI.b(this.qxy).field_bankcardType, WalletWXCreditOpenUI.b(this.qxy).field_bankName, true, false);
    }
}

package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.ui.e;

class WalletBankcardManageUI$4 implements OnClickListener {
    final /* synthetic */ WalletBankcardManageUI pdm;

    WalletBankcardManageUI$4(WalletBankcardManageUI walletBankcardManageUI) {
        this.pdm = walletBankcardManageUI;
    }

    public final void onClick(View view) {
        this.pdm.bNj();
        e.He(19);
        h.mEJ.h(14422, new Object[]{Integer.valueOf(2)});
    }
}

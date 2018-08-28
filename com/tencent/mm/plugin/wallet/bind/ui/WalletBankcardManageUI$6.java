package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class WalletBankcardManageUI$6 implements OnClickListener {
    final /* synthetic */ WalletBankcardManageUI pdm;
    final /* synthetic */ f pdo;

    WalletBankcardManageUI$6(WalletBankcardManageUI walletBankcardManageUI, f fVar) {
        this.pdm = walletBankcardManageUI;
        this.pdo = fVar;
    }

    public final void onClick(View view) {
        if (!bi.oW(this.pdo.pmv)) {
            e.l(this.pdm.mController.tml, this.pdo.pmv, false);
        }
    }
}

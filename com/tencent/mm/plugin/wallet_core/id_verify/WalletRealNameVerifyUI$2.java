package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class WalletRealNameVerifyUI$2 implements OnClickListener {
    final /* synthetic */ WalletRealNameVerifyUI pkE;

    WalletRealNameVerifyUI$2(WalletRealNameVerifyUI walletRealNameVerifyUI) {
        this.pkE = walletRealNameVerifyUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("GetAddress", true);
        intent.putExtra("ShowSelectedLocation", false);
        intent.putExtra("IsRealNameVerifyScene", true);
        intent.putExtra("IsNeedShowSearchBar", true);
        d.b(this.pkE.mController.tml, ".ui.tools.MultiStageCitySelectUI", intent, 2);
    }
}

package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI;

class WalletRealNameVerifyUI$1 implements OnClickListener {
    final /* synthetic */ WalletRealNameVerifyUI pkE;

    WalletRealNameVerifyUI$1(WalletRealNameVerifyUI walletRealNameVerifyUI) {
        this.pkE = walletRealNameVerifyUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.pkE.mController.tml, WalletSelectProfessionUI.class);
        intent.putExtra("key_profession_list", WalletRealNameVerifyUI.a(this.pkE));
        this.pkE.startActivityForResult(intent, 1);
    }
}

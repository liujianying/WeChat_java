package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class WalletCardElementUI$11 implements OnClickListener {
    final /* synthetic */ WalletCardElementUI pun;

    WalletCardElementUI$11(WalletCardElementUI walletCardElementUI) {
        this.pun = walletCardElementUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.pun.mController.tml, WalletSelectProfessionUI.class);
        intent.putExtra("key_profession_list", WalletCardElementUI.i(this.pun));
        this.pun.startActivityForResult(intent, 5);
    }
}

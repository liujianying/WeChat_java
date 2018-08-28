package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

class WalletCardElementUI$14 implements OnClickListener {
    final /* synthetic */ WalletCardElementUI pun;

    WalletCardElementUI$14(WalletCardElementUI walletCardElementUI) {
        this.pun = walletCardElementUI;
    }

    public final void onClick(View view) {
        Intent putExtra = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
        if (Bankcard.zj(WalletCardElementUI.d(this.pun).pjA)) {
            putExtra.putExtra("IsAutoPosition", false);
        } else {
            putExtra.putExtra("IsRealNameVerifyScene", true);
            putExtra.putExtra("IsNeedShowSearchBar", true);
        }
        this.pun.startActivityForResult(putExtra, 2);
    }
}

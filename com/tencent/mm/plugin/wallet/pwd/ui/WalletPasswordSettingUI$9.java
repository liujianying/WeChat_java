package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletPasswordSettingUI$9 implements OnCancelListener {
    final /* synthetic */ WalletPasswordSettingUI pif;

    WalletPasswordSettingUI$9(WalletPasswordSettingUI walletPasswordSettingUI) {
        this.pif = walletPasswordSettingUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (WalletPasswordSettingUI.g(this.pif) != null) {
            WalletPasswordSettingUI.g(this.pif).dismiss();
        }
    }
}

package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class WalletBalanceFetchPwdInputUI$3 implements OnCancelListener {
    final /* synthetic */ WalletBalanceFetchPwdInputUI oZE;

    WalletBalanceFetchPwdInputUI$3(WalletBalanceFetchPwdInputUI walletBalanceFetchPwdInputUI) {
        this.oZE = walletBalanceFetchPwdInputUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: dialog cancel. finish");
        WalletBalanceFetchPwdInputUI.a(this.oZE).dismiss();
        this.oZE.finish();
    }
}

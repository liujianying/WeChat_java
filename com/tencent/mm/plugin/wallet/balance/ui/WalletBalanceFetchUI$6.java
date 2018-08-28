package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet.balance.a.b;

class WalletBalanceFetchUI$6 implements OnClickListener {
    final /* synthetic */ WalletBalanceFetchUI pad;

    WalletBalanceFetchUI$6(WalletBalanceFetchUI walletBalanceFetchUI) {
        this.pad = walletBalanceFetchUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        String str = "";
        if (WalletBalanceFetchUI.a(this.pad) != null) {
            str = WalletBalanceFetchUI.a(this.pad).field_bankcardType;
        }
        WalletBalanceFetchUI.k(this.pad);
        WalletBalanceFetchUI.l(this.pad);
        this.pad.a(new b(WalletBalanceFetchUI.m(this.pad), "CNY", str, WalletBalanceFetchUI.n(this.pad)), true, true);
    }
}

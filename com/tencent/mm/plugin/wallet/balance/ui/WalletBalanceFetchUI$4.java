package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet.balance.a.b;

class WalletBalanceFetchUI$4 implements OnClickListener {
    final /* synthetic */ WalletBalanceFetchUI pad;
    final /* synthetic */ b pag;

    WalletBalanceFetchUI$4(WalletBalanceFetchUI walletBalanceFetchUI, b bVar) {
        this.pad = walletBalanceFetchUI;
        this.pag = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (!WalletBalanceFetchUI.a(this.pad, this.pag)) {
            WalletBalanceFetchUI.a(this.pad, this.pag.bQa);
            WalletBalanceFetchUI.b(this.pad, this.pag);
        }
    }
}

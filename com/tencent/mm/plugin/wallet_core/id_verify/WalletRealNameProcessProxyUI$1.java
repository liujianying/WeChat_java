package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletRealNameProcessProxyUI$1 implements OnClickListener {
    final /* synthetic */ WalletRealNameProcessProxyUI pkt;

    WalletRealNameProcessProxyUI$1(WalletRealNameProcessProxyUI walletRealNameProcessProxyUI) {
        this.pkt = walletRealNameProcessProxyUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pkt.setResult(1);
        this.pkt.finish();
    }
}

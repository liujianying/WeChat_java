package com.tencent.mm.plugin.wallet.pwd;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class c$3 implements OnClickListener {
    final /* synthetic */ WalletBaseUI peV;
    final /* synthetic */ c phe;

    c$3(c cVar, WalletBaseUI walletBaseUI) {
        this.phe = cVar;
        this.peV = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.phe.b(this.peV, c.f(this.phe));
        if (this.peV.bbR()) {
            this.peV.finish();
        }
        WalletBaseUI.cDI();
    }
}

package com.tencent.mm.plugin.wallet.pwd;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class a$5 implements OnClickListener {
    final /* synthetic */ WalletBaseUI peV;
    final /* synthetic */ a phb;

    a$5(a aVar, WalletBaseUI walletBaseUI) {
        this.phb = aVar;
        this.peV = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.phb.b(this.peV, a.g(this.phb));
        if (this.peV.bbR()) {
            this.peV.finish();
        }
        WalletBaseUI.cDI();
    }
}

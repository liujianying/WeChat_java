package com.tencent.mm.plugin.wallet.pay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$7 implements OnClickListener {
    final /* synthetic */ b peU;
    final /* synthetic */ WalletBaseUI peV;

    b$7(b bVar, WalletBaseUI walletBaseUI) {
        this.peU = bVar;
        this.peV = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.peU.b(this.peV, b.B(this.peU));
        if (this.peV.bbR()) {
            this.peV.finish();
        }
    }
}

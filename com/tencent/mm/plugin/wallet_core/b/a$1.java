package com.tencent.mm.plugin.wallet_core.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class a$1 implements OnClickListener {
    final /* synthetic */ WalletBaseUI peV;
    final /* synthetic */ a piU;

    a$1(a aVar, WalletBaseUI walletBaseUI) {
        this.piU = aVar;
        this.peV = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.piU.b(this.peV, this.piU.jfZ);
        if (this.peV.bbR()) {
            this.peV.finish();
        }
        WalletBaseUI.cDI();
    }
}

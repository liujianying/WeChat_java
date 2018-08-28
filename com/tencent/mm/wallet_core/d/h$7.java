package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class h$7 implements OnClickListener {
    final /* synthetic */ WalletBaseUI peV;

    h$7(WalletBaseUI walletBaseUI) {
        this.peV = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.peV.bbR()) {
            this.peV.finish();
        }
    }
}

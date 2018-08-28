package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class h$6 implements OnClickListener {
    final /* synthetic */ int bFr;
    final /* synthetic */ WalletBaseUI peV;

    h$6(WalletBaseUI walletBaseUI, int i) {
        this.peV = walletBaseUI;
        this.bFr = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.c(this.peV, null, this.bFr);
        if (this.peV.bbR()) {
            this.peV.finish();
        }
    }
}

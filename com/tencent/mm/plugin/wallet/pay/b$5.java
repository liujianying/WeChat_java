package com.tencent.mm.plugin.wallet.pay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$5 implements OnClickListener {
    final /* synthetic */ int bFr;
    final /* synthetic */ b peU;
    final /* synthetic */ WalletBaseUI peV;

    b$5(b bVar, int i, WalletBaseUI walletBaseUI) {
        this.peU = bVar;
        this.bFr = i;
        this.peV = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.w(this.peU).putInt("key_pay_flag", 3);
        b.x(this.peU).putInt("key_err_code", this.bFr);
        this.peU.a(this.peV, 0, b.y(this.peU));
        if (this.peV.bbR()) {
            this.peV.finish();
        }
    }
}

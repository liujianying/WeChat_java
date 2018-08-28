package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.a;

class WalletBrandUI$a$1 implements OnClickListener {
    final /* synthetic */ a pDE;

    WalletBrandUI$a$1(a aVar) {
        this.pDE = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pDE.pDC.setResult(0);
        this.pDE.pDC.finish();
    }
}

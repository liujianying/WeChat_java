package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;

class WalletBrandUI$1 implements OnCancelListener {
    final /* synthetic */ l bFp;
    final /* synthetic */ WalletBrandUI pDC;

    WalletBrandUI$1(WalletBrandUI walletBrandUI, l lVar) {
        this.pDC = walletBrandUI;
        this.bFp = lVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.Ek();
        g.Eh().dpP.c(this.bFp);
        this.pDC.finish();
    }
}

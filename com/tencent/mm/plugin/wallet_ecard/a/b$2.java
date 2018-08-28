package com.tencent.mm.plugin.wallet_ecard.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.protocal.c.bbc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$2 implements OnClickListener {
    final /* synthetic */ bbc pBU;
    final /* synthetic */ WalletBaseUI pBV;

    b$2(bbc bbc, WalletBaseUI walletBaseUI) {
        this.pBU = bbc;
        this.pBV = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c cDK;
        if (this.pBU.rNB == a.pBu) {
            x.i("MicroMsg.ECardUtil", "do end process");
            cDK = this.pBV.cDK();
            if (cDK != null) {
                cDK.b(this.pBV, new Bundle());
            } else {
                this.pBV.finish();
            }
        } else if (this.pBU.rNB == a.pBx) {
            x.i("MicroMsg.ECardUtil", "back bank list");
            cDK = this.pBV.cDK();
            if (cDK != null) {
                cDK.c(this.pBV, 100);
            } else {
                this.pBV.finish();
            }
        }
        dialogInterface.dismiss();
    }
}

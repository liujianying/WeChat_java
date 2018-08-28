package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.b.a.c;
import com.tencent.mm.plugin.wallet_index.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.q;

class WalletIapUI$2 implements d {
    final /* synthetic */ WalletIapUI pDI;

    WalletIapUI$2(WalletIapUI walletIapUI) {
        this.pDI = walletIapUI;
    }

    public final void a(a aVar, c cVar) {
        x.i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + aVar + ", purchase: " + cVar);
        if (WalletIapUI.a(this.pDI) instanceof a) {
            if (cVar != null) {
                q.c(cVar.pCF, cVar.iiv, cVar.pCL, aVar.kjf, aVar.kjg);
            } else {
                a aVar2 = (a) WalletIapUI.a(this.pDI);
                q.c(aVar2.pDh, aVar2.iiv, aVar2.pCL, aVar.kjf, aVar.kjg);
            }
        }
        Intent intent;
        if (aVar.isFailure()) {
            x.i("MicroMsg.WalletIapUI", "back to preview UI, reason: purchase finish , errCode: " + aVar.kjf + " , errMsg: " + aVar.kjg);
            intent = new Intent();
            intent.putExtra("key_err_code", aVar.kjf);
            intent.putExtra("key_err_msg", aVar.kjg);
            intent.putExtra("key_launch_ts", a.pDd);
            intent.putExtra("key_gw_error_code", aVar.pCM);
            this.pDI.setResult(-1, intent);
            this.pDI.finish();
        } else if (aVar.bRc()) {
            x.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
            WalletIapUI.a(this.pDI).b(this.pDI, false);
        } else if (cVar != null) {
            x.i("MicroMsg.WalletIapUI", "verify purchase! productId:" + cVar.iiv + ",billNo:" + cVar.pCI);
            g.Ek();
            g.Eh().dpP.a(WalletIapUI.b(this.pDI).a(cVar, false), 0);
        } else {
            intent = new Intent();
            a.aN(6, "");
            intent.putExtra("key_err_code", aVar.kjf);
            intent.putExtra("key_err_msg", aVar.kjg);
            intent.putExtra("key_launch_ts", a.pDd);
            intent.putExtra("key_gw_error_code", aVar.pCM);
            this.pDI.setResult(-1, intent);
            this.pDI.finish();
        }
    }
}

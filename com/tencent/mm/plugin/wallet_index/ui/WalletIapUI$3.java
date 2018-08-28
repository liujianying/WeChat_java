package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.mm.plugin.wallet_index.b.a.c;
import com.tencent.mm.plugin.wallet_index.c.a;
import com.tencent.mm.sdk.platformtools.x;

class WalletIapUI$3 implements d {
    final /* synthetic */ WalletIapUI pDI;

    WalletIapUI$3(WalletIapUI walletIapUI) {
        this.pDI = walletIapUI;
    }

    public final void a(a aVar, c cVar) {
        x.d("MicroMsg.WalletIapUI", "Consume finished: " + aVar + ", purchase: " + cVar);
        if (aVar.isFailure()) {
            x.d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Fail ! ");
        } else {
            x.d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Success ! ");
        }
        Intent intent = new Intent();
        intent.putExtra("key_err_code", aVar.kjf);
        intent.putExtra("key_err_msg", aVar.kjg);
        intent.putStringArrayListExtra("key_response_product_ids", WalletIapUI.b(this.pDI).pDk);
        intent.putStringArrayListExtra("key_response_series_ids", WalletIapUI.b(this.pDI).pDl);
        intent.putExtra("key_launch_ts", a.pDd);
        this.pDI.setResult(-1, intent);
        this.pDI.finish();
    }
}

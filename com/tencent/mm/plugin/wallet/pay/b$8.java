package com.tencent.mm.plugin.wallet.pay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$8 implements OnClickListener {
    final /* synthetic */ b peU;
    final /* synthetic */ WalletBaseUI peV;

    b$8(b bVar, WalletBaseUI walletBaseUI) {
        this.peU = bVar;
        this.peV = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Bankcard bankcard = (Bankcard) b.C(this.peU).getParcelable("key_bankcard");
        PayInfo payInfo = (PayInfo) b.D(this.peU).getParcelable("key_pay_info");
        if (!(bankcard == null || payInfo == null)) {
            bankcard.plU = payInfo.bOd;
        }
        b.E(this.peU).putInt("key_err_code", -1004);
        this.peU.a(this.peV, 0, b.F(this.peU));
        if (this.peV.bbR()) {
            this.peV.finish();
        }
    }
}

package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

class WalletOrderInfoUI$1 implements a {
    final /* synthetic */ WalletOrderInfoUI pxa;

    WalletOrderInfoUI$1(WalletOrderInfoUI walletOrderInfoUI) {
        this.pxa = walletOrderInfoUI;
    }

    public final void x(String str, boolean z) {
        g.Ek();
        ab Yg = ((i) g.l(i.class)).FR().Yg(str);
        x.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer " + str + " succ: " + z);
        this.pxa.M(Yg);
    }
}

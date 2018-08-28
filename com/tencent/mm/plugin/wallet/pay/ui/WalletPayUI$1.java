package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.g.a.tl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletPayUI$1 extends c<tl> {
    final /* synthetic */ WalletPayUI pgT;

    WalletPayUI$1(WalletPayUI walletPayUI) {
        this.pgT = walletPayUI;
        this.sFo = tl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.WalletPayUI", "WalletRealNameResultNotifyMoreEvent %s", new Object[]{Integer.valueOf(((tl) bVar).ceY.result)});
        if (((tl) bVar).ceY.result == -1) {
            WalletPayUI.a(this.pgT);
            WalletPayUI.b(this.pgT);
            this.pgT.bNK();
        }
        return false;
    }
}

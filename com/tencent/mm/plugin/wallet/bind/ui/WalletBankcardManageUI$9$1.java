package com.tencent.mm.plugin.wallet.bind.ui;

import com.tencent.mm.g.a.ac;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.9;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletBankcardManageUI$9$1 extends c<ac> {
    final /* synthetic */ Bankcard oZt;
    final /* synthetic */ 9 pdq;

    WalletBankcardManageUI$9$1(9 9, Bankcard bankcard) {
        this.pdq = 9;
        this.oZt = bankcard;
        this.sFo = ac.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        a.sFg.c(this);
        x.i("MicroMsg.WalletBankcardManageUI", "BankcardLogoReady,jump bank url");
        this.pdq.pdm.b(this.oZt);
        return true;
    }
}

package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.ui.d;

class WalletDigitalCertUI$2 extends d {
    final /* synthetic */ WalletDigitalCertUI phy;

    WalletDigitalCertUI$2(WalletDigitalCertUI walletDigitalCertUI) {
        this.phy = walletDigitalCertUI;
    }

    public final void onClick(View view) {
        s.cDi();
        this.phy.a(new f(s.cDh()), true, true);
        h.mEJ.h(13731, new Object[]{Integer.valueOf(10)});
    }
}

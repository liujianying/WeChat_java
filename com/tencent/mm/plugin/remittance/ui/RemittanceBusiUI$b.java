package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.d.c;
import com.tencent.mm.wallet_core.d.d;

class RemittanceBusiUI$b implements Runnable {
    public d mBH;
    final /* synthetic */ RemittanceBusiUI mBt;

    RemittanceBusiUI$b(RemittanceBusiUI remittanceBusiUI) {
        this.mBt = remittanceBusiUI;
    }

    public final void run() {
        c D = RemittanceBusiUI.D(this.mBt);
        d dVar = this.mBH;
        x.i("MicroMsg.IDelayQueryOrder", "doScene rtType %s", new Object[]{Integer.valueOf(D.rtType)});
        g.Ek();
        g.Eh().dpP.a(D.rtType, D);
        D.a(dVar);
    }
}

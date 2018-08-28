package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class HoneyPayProxyUI$3 implements a {
    final /* synthetic */ HoneyPayProxyUI klM;
    final /* synthetic */ l klN;

    HoneyPayProxyUI$3(HoneyPayProxyUI honeyPayProxyUI, l lVar) {
        this.klM = honeyPayProxyUI;
        this.klN = lVar;
    }

    public final void g(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i(this.klM.TAG, "state: %s", new Object[]{Integer.valueOf(this.klN.kjM.ruX.state)});
        HoneyPayProxyUI.a(this.klM, this.klN.kjM);
        this.klM.finish();
    }
}

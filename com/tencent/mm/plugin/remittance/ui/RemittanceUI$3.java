package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.model.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class RemittanceUI$3 implements a {
    final /* synthetic */ e mDr;
    final /* synthetic */ RemittanceUI mDs;

    RemittanceUI$3(RemittanceUI remittanceUI, e eVar) {
        this.mDs = remittanceUI;
        this.mDr = eVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.RemittanceUI", "mask_name: %s", new Object[]{this.mDr.mwY.rqF});
        this.mDs.mzk = this.mDr.mwY.rqF;
        this.mDs.brt();
    }
}

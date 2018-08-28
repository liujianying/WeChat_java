package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.aa.c;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class RemittanceBaseUI$18 implements a {
    final /* synthetic */ long hWz;
    final /* synthetic */ RemittanceBaseUI mzz;

    RemittanceBaseUI$18(RemittanceBaseUI remittanceBaseUI, long j) {
        this.mzz = remittanceBaseUI;
        this.hWz = j;
    }

    public final void x(String str, boolean z) {
        if (z) {
            x.v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (bi.VF() - this.hWz) + " ms");
            c.J(str, 3);
        } else {
            x.w("MicroMsg.RemittanceBaseUI", "getContact failed");
        }
        RemittanceBaseUI.c(this.mzz);
    }
}

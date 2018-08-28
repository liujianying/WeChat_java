package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.model.am.b.a;
import com.tencent.mm.sdk.platformtools.x;

class RemittanceBusiUI$22 implements a {
    final /* synthetic */ RemittanceBusiUI mBt;

    RemittanceBusiUI$22(RemittanceBusiUI remittanceBusiUI) {
        this.mBt = remittanceBusiUI;
    }

    public final void x(String str, boolean z) {
        x.i("MicroMsg.RemittanceBusiUI", "getContact %s", new Object[]{Boolean.valueOf(z)});
        RemittanceBusiUI.i(this.mBt);
    }
}

package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.wallet_core.ui.a;

class RemittanceBaseUI$2 implements a {
    final /* synthetic */ RemittanceBaseUI mzz;

    RemittanceBaseUI$2(RemittanceBaseUI remittanceBaseUI) {
        this.mzz = remittanceBaseUI;
    }

    public final void fI(boolean z) {
        if (z) {
            RemittanceBaseUI.a(this.mzz, this.mzz.klj, this.mzz.eWk);
        } else {
            this.mzz.klj.scrollTo(0, 0);
        }
    }
}

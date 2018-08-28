package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.15;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h.b;

class RemittanceBaseUI$15$1 implements b {
    final /* synthetic */ 15 mzD;

    RemittanceBaseUI$15$1(15 15) {
        this.mzD = 15;
    }

    public final boolean p(CharSequence charSequence) {
        if (bi.oW(charSequence.toString())) {
            this.mzD.mzz.cZG = null;
            RemittanceBaseUI.b(this.mzD.mzz);
        } else {
            this.mzD.mzz.cZG = charSequence.toString();
            RemittanceBaseUI.b(this.mzD.mzz);
        }
        return true;
    }
}

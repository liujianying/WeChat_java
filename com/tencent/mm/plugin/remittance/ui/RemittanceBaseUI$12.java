package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.u;

class RemittanceBaseUI$12 extends u {
    final /* synthetic */ RemittanceBaseUI mzz;

    RemittanceBaseUI$12(RemittanceBaseUI remittanceBaseUI) {
        this.mzz = remittanceBaseUI;
    }

    public final void aBU() {
        if (this.mzz.myU == 33) {
            this.mzz.a(this.mzz.cZG, this.mzz.mzh, "", null);
        } else {
            this.mzz.myQ = bi.getDouble(this.mzz.hXD.getText(), 0.0d);
            if (!this.mzz.hXD.ZF()) {
                s.makeText(this.mzz.mController.tml, i.wallet_balance_save_input_invalid, 0).show();
            } else if (this.mzz.myQ < 0.01d) {
                this.mzz.brp();
            } else {
                this.mzz.a(this.mzz.cZG, null, "", null);
            }
        }
        if (RemittanceBaseUI.a(this.mzz) == 0.0d) {
            if (this.mzz.fdx == 1) {
                h.mEJ.h(12689, new Object[]{Integer.valueOf(15), Integer.valueOf(1)});
            } else {
                h.mEJ.h(12689, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
            }
        }
        if (this.mzz.fdx == 1 && !bi.oW(this.mzz.cZG)) {
            h.mEJ.h(14074, new Object[]{Integer.valueOf(2)});
        }
    }
}

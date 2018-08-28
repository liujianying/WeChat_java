package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.plugin.remittance.model.d;
import com.tencent.mm.plugin.remittance.model.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.s;

class RemittanceBusiUI$5 implements d {
    final /* synthetic */ RemittanceBusiUI mBt;

    RemittanceBusiUI$5(RemittanceBusiUI remittanceBusiUI) {
        this.mBt = remittanceBusiUI;
    }

    public final void a(int i, int i2, g gVar) {
        if (i != 0 || i2 != 0) {
            s.makeText(this.mBt.mController.tml, this.mBt.getString(i.wallet_data_err), 0).show();
        } else if (gVar.mxb.hwV != 0) {
            s.makeText(this.mBt.mController.tml, gVar.mxb.hwW, 0).show();
        }
    }
}

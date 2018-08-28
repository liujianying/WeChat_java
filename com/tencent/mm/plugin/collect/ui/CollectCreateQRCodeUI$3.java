package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.base.s;

class CollectCreateQRCodeUI$3 implements OnClickListener {
    final /* synthetic */ CollectCreateQRCodeUI hXF;

    CollectCreateQRCodeUI$3(CollectCreateQRCodeUI collectCreateQRCodeUI) {
        this.hXF = collectCreateQRCodeUI;
    }

    public final void onClick(View view) {
        double d = bi.getDouble(CollectCreateQRCodeUI.a(this.hXF).getText(), 0.0d);
        g.Ek();
        x.i("MicroMsg.CollectCreateQRCodeUI", "wallet region: %s", new Object[]{Integer.valueOf(((Integer) g.Ei().DT().get(a.sTs, Integer.valueOf(0))).intValue())});
        if (!CollectCreateQRCodeUI.a(this.hXF).ZF()) {
            s.makeText(this.hXF.mController.tml, i.wallet_balance_save_input_invalid, 0).show();
        } else if (d < 0.01d) {
            s.makeText(this.hXF.mController.tml, i.remittance_amount_lowest_limit, 0).show();
        } else if (r0 == 8) {
            this.hXF.a(new m(Math.round(d * 100.0d), CollectCreateQRCodeUI.b(this.hXF), q.GM()), true, false);
        } else {
            this.hXF.a(new com.tencent.mm.plugin.collect.b.s(d, "1", CollectCreateQRCodeUI.b(this.hXF)), true, true);
        }
    }
}

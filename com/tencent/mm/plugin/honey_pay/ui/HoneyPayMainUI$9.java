package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.honey_pay.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h$a;

class HoneyPayMainUI$9 implements h$a {
    final /* synthetic */ HoneyPayMainUI klC;
    final /* synthetic */ f klG;

    HoneyPayMainUI$9(HoneyPayMainUI honeyPayMainUI, f fVar) {
        this.klC = honeyPayMainUI;
        this.klG = fVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        HoneyPayMainUI.b(this.klC);
        this.klC.mController.removeAllOptionMenu();
        if (this.klG.kjF.rPg == null || this.klG.kjF.rPg.isEmpty()) {
            x.i(this.klC.TAG, "empty card");
            HoneyPayMainUI.a(this.klC, this.klG.kjF.rPh);
            HoneyPayMainUI.c(this.klC).setVisibility(8);
            this.klC.kjV = c.white;
        } else {
            HoneyPayMainUI.d(this.klC);
            HoneyPayMainUI.a(this.klC, this.klG.kjF.rPg);
            x.i(this.klC.TAG, "show open card: %s", new Object[]{Boolean.valueOf(this.klG.kjF.rPj)});
            if (this.klG.kjF.rPj) {
                HoneyPayMainUI.c(this.klC).setVisibility(0);
            } else {
                HoneyPayMainUI.c(this.klC).setVisibility(8);
            }
            this.klC.kjV = c.honey_pay_grey_bg_1;
        }
        this.klC.aWd();
        this.klC.findViewById(a.f.hpou_root_view).setBackgroundResource(this.klC.kjV);
        com.tencent.mm.plugin.honey_pay.model.c.a(this.klC, this.klG.kjF.rPi, null, 0, null);
        this.klC.findViewById(a.f.hpou_block_view).setVisibility(8);
        h.mEJ.e(875, 0, 1);
    }
}

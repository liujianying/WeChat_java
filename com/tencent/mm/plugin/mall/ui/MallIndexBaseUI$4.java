package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.wallet_core.a;

class MallIndexBaseUI$4 implements d {
    final /* synthetic */ MallIndexBaseUI kZq;

    MallIndexBaseUI$4(MallIndexBaseUI mallIndexBaseUI) {
        this.kZq = mallIndexBaseUI;
    }

    public final void bx(int i, int i2) {
        switch (i2) {
            case 0:
                h.mEJ.h(11458, new Object[]{Integer.valueOf(2)});
                if (q.GS()) {
                    a.b(this.kZq.mController.tml, "PayURemittanceProcess", null);
                    return;
                } else {
                    a.b(this.kZq.mController.tml, "RemittanceProcess", null);
                    return;
                }
            case 1:
                h.mEJ.h(11458, new Object[]{Integer.valueOf(3)});
                com.tencent.mm.pluginsdk.wallet.h.Z(this.kZq, 2);
                return;
            default:
                return;
        }
    }
}

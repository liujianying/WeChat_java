package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class PaylistAAUI$10 implements a<Void, v> {
    final /* synthetic */ PaylistAAUI eEl;

    PaylistAAUI$10(PaylistAAUI paylistAAUI) {
        this.eEl = paylistAAUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        v vVar = (v) obj;
        if (vVar == null) {
            x.e("MicroMsg.PaylistAAUI", "queryDetailRes is null!!!");
            PaylistAAUI.a(this.eEl, null);
        } else {
            x.i("MicroMsg.PaylistAAUI", "get queryDetailRes: %s, billNo: %s, type: %s, state: %s, is_launcher: %s, role: %s, role_state: %s, payer_list.size: %s", new Object[]{vVar, vVar.qYc, Integer.valueOf(vVar.type), Integer.valueOf(vVar.state), Integer.valueOf(vVar.qYH), Integer.valueOf(vVar.qYn), Integer.valueOf(vVar.qYI), Integer.valueOf(vVar.qYh.size())});
            x.i("MicroMsg.PaylistAAUI", "paid_num: %s, plan_num: %s, activity_amount: %s", new Object[]{Integer.valueOf(vVar.qYF), Integer.valueOf(vVar.qYD), Long.valueOf(vVar.qYP)});
            PaylistAAUI.c(this.eEl).setVisibility(0);
            PaylistAAUI.b(this.eEl, vVar.qYB);
            PaylistAAUI.a(this.eEl, vVar.qYh.size() + 1);
            PaylistAAUI.c(this.eEl, vVar.title);
            PaylistAAUI.a(this.eEl, vVar);
            PaylistAAUI.b(this.eEl, vVar);
            PaylistAAUI.c(this.eEl, vVar);
            PaylistAAUI.d(this.eEl, vVar);
            PaylistAAUI.e(this.eEl, vVar);
            if (PaylistAAUI.d(this.eEl) != null) {
                PaylistAAUI.d(this.eEl).dismiss();
                PaylistAAUI.e(this.eEl);
            }
        }
        return uQG;
    }
}

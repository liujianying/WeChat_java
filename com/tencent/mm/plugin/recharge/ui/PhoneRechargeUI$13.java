package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.a;
import java.util.List;

class PhoneRechargeUI$13 implements a {
    final /* synthetic */ PhoneRechargeUI mqa;
    final /* synthetic */ List mqe;
    final /* synthetic */ String mqf;

    PhoneRechargeUI$13(PhoneRechargeUI phoneRechargeUI, List list, String str) {
        this.mqa = phoneRechargeUI;
        this.mqe = list;
        this.mqf = str;
    }

    public final void vh(int i) {
        x.d("MicroMsg.PhoneRechargeUI", "choose: %d", new Object[]{Integer.valueOf(i)});
        PhoneRechargeUI.b(this.mqa).setInput(new com.tencent.mm.plugin.recharge.model.a((String) this.mqe.get(i), this.mqf, 1));
        PhoneRechargeUI.n(this.mqa);
    }
}

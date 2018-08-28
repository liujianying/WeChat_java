package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.12;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class PhoneRechargeUI$12$1 implements Runnable {
    final /* synthetic */ String mqb;
    final /* synthetic */ 12 mqc;

    PhoneRechargeUI$12$1(12 12, String str) {
        this.mqc = 12;
        this.mqb = str;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        a a = PhoneRechargeUI.a(this.mqc.mqa, this.mqb);
        x.d("MicroMsg.PhoneRechargeUI", "handle cost: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        ah.A(new 1(this, a));
    }
}

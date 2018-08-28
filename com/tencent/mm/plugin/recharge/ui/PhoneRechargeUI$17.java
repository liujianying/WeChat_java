package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class PhoneRechargeUI$17 implements b$a {
    final /* synthetic */ PhoneRechargeUI mqa;

    PhoneRechargeUI$17(PhoneRechargeUI phoneRechargeUI) {
        this.mqa = phoneRechargeUI;
    }

    public final void a(n nVar) {
        if (!PhoneRechargeUI.a(this.mqa, nVar.pdR, nVar.dzE)) {
            if (!bi.oW(nVar.url)) {
                PhoneRechargeUI.c(this.mqa, PhoneRechargeUI.b(this.mqa, nVar.url));
            } else if (PhoneRechargeUI.a(this.mqa, nVar)) {
                PhoneRechargeUI.d(this.mqa, nVar.id);
            } else {
                x.w("MicroMsg.PhoneRechargeUI", "error dataFlow click");
            }
        }
    }
}

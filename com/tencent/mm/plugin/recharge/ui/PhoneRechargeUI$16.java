package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class PhoneRechargeUI$16 implements b$a {
    final /* synthetic */ PhoneRechargeUI mqa;

    PhoneRechargeUI$16(PhoneRechargeUI phoneRechargeUI) {
        this.mqa = phoneRechargeUI;
    }

    public final void a(n nVar) {
        if (nVar == null) {
            x.e("MicroMsg.PhoneRechargeUI", "hy: no product item");
        } else if (!PhoneRechargeUI.a(this.mqa, nVar.pdR, nVar.dzE)) {
            if (!bi.oW(nVar.url)) {
                PhoneRechargeUI.c(this.mqa, PhoneRechargeUI.b(this.mqa, nVar.url));
            } else if (PhoneRechargeUI.a(this.mqa, nVar)) {
                PhoneRechargeUI.d(this.mqa, nVar.id);
            }
        }
    }
}

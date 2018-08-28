package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.g.a.te;
import com.tencent.mm.plugin.recharge.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class PhoneRechargeUI$14 extends c<te> {
    final /* synthetic */ PhoneRechargeUI mqa;

    PhoneRechargeUI$14(PhoneRechargeUI phoneRechargeUI) {
        this.mqa = phoneRechargeUI;
        this.sFo = te.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        te teVar = (te) bVar;
        if (teVar instanceof te) {
            if (teVar.ceH.result != -1) {
                x.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
            } else if (!PhoneRechargeUI.o(this.mqa)) {
                x.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                a.bpV().a(new com.tencent.mm.plugin.recharge.model.a(PhoneRechargeUI.a(this.mqa).getText(), PhoneRechargeUI.b(this.mqa).mph != null ? bi.oV(PhoneRechargeUI.b(this.mqa).mph.name) : "", 0));
                this.mqa.finish();
                PhoneRechargeUI.p(this.mqa);
            }
            return true;
        }
        x.f("MicroMsg.PhoneRechargeUI", "hy: mismatched event");
        return false;
    }
}

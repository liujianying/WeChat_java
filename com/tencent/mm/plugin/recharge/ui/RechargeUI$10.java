package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.g.a.te;
import com.tencent.mm.plugin.recharge.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class RechargeUI$10 extends c<te> {
    final /* synthetic */ RechargeUI mqE;

    RechargeUI$10(RechargeUI rechargeUI) {
        this.mqE = rechargeUI;
        this.sFo = te.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        te teVar = (te) bVar;
        if (teVar instanceof te) {
            if (teVar.ceH.result != -1) {
                x.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
            } else if (!RechargeUI.p(this.mqE)) {
                x.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
                a.bpV().a(RechargeUI.e(this.mqE).getInputRecord());
                this.mqE.finish();
                RechargeUI.q(this.mqE);
            }
            return true;
        }
        x.f("MicroMsg.MallRechargeUI", "mismatched event");
        return false;
    }
}

package com.tencent.mm.plugin.wallet_index.ui;

import android.os.Bundle;
import com.tencent.mm.g.a.te;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class OrderHandlerUI$1 extends c<te> {
    final /* synthetic */ OrderHandlerUI pDx;

    OrderHandlerUI$1(OrderHandlerUI orderHandlerUI) {
        this.pDx = orderHandlerUI;
        this.sFo = te.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        te teVar = (te) bVar;
        if (teVar instanceof te) {
            OrderHandlerUI.a(this.pDx);
            x.e("MicroMsg.OrderHandlerUI", "onPayEnd, isOk = %s notifyPay %s", new Object[]{Integer.valueOf(teVar.ceH.result), Boolean.valueOf(OrderHandlerUI.b(this.pDx))});
            if (!OrderHandlerUI.b(this.pDx)) {
                if (bi.oW(teVar.ceH.bOd) || teVar.ceH.bOd.equals(OrderHandlerUI.c(this.pDx))) {
                    if (teVar.ceH.result == -1) {
                        Bundle extras = teVar.ceH.intent.getExtras();
                        String string = extras.getString("intent_pay_app_url");
                        OrderHandlerUI.a(this.pDx, extras.getString("intent_wap_pay_jump_url"));
                        x.d("MicroMsg.OrderHandlerUI", "onPayEnd, returnUrl = " + string);
                        OrderHandlerUI.d(this.pDx).errCode = 0;
                        OrderHandlerUI.d(this.pDx).returnKey = string;
                    } else {
                        OrderHandlerUI.d(this.pDx).errCode = -2;
                    }
                    if (OrderHandlerUI.e(this.pDx) == 1) {
                        OrderHandlerUI.aT(this.pDx, OrderHandlerUI.f(this.pDx));
                    } else {
                        e.a(this.pDx, OrderHandlerUI.g(this.pDx), OrderHandlerUI.d(this.pDx), OrderHandlerUI.h(this.pDx));
                    }
                    OrderHandlerUI.i(this.pDx);
                    this.pDx.finish();
                } else {
                    x.e("MicroMsg.OrderHandlerUI", "pass notify this req1 %s req2 %s", new Object[]{teVar.ceH.bOd, OrderHandlerUI.c(this.pDx)});
                }
            }
        } else {
            x.f("MicroMsg.OrderHandlerUI", "mismatched event");
        }
        return false;
    }
}

package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.vending.c.a;

class PaylistAAUI$2 implements a<Void, o> {
    final /* synthetic */ PaylistAAUI eEl;

    PaylistAAUI$2(PaylistAAUI paylistAAUI) {
        this.eEl = paylistAAUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        o oVar = (o) obj;
        if (PaylistAAUI.d(this.eEl) != null) {
            PaylistAAUI.d(this.eEl).dismiss();
        }
        String str = "MicroMsg.PaylistAAUI";
        String str2 = "aapay return, alertItem: %s, alertItem.flag: %s";
        Object[] objArr = new Object[2];
        objArr[0] = oVar.qYw;
        objArr[1] = Integer.valueOf(oVar.qYw != null ? oVar.qYw.bWA : 0);
        x.i(str, str2, objArr);
        if (oVar.qYw == null || oVar.qYw.bWA != 1) {
            x.d("MicroMsg.PaylistAAUI", "aapay return, reqKey: %s", new Object[]{oVar.kRq});
            PaylistAAUI.a(this.eEl, oVar);
        } else {
            String str3 = oVar.qYw.bSc;
            String str4 = oVar.qYw.kRu;
            str = oVar.qYw.kRv;
            c.a aVar = new c.a(this.eEl);
            aVar.abu(str3);
            aVar.abx(str).a(new 1(this, oVar));
            aVar.aby(str4);
            aVar.anj().show();
        }
        return uQG;
    }
}

package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.vending.g.d.a;

class PaylistAAUI$15 implements a {
    final /* synthetic */ PaylistAAUI eEl;

    PaylistAAUI$15(PaylistAAUI paylistAAUI) {
        this.eEl = paylistAAUI;
    }

    public final void bd(Object obj) {
        x.i("MicroMsg.PaylistAAUI", "aapay failed: %s", new Object[]{obj});
        if (PaylistAAUI.d(this.eEl) != null) {
            PaylistAAUI.d(this.eEl).dismiss();
        }
        if (obj == null) {
            Toast.makeText(this.eEl, this.eEl.getString(i.aa_pay_failed), 1).show();
        } else if (obj instanceof com.tencent.mm.protocal.c.a) {
            com.tencent.mm.protocal.c.a aVar = (com.tencent.mm.protocal.c.a) obj;
            String str = aVar.bSc;
            String str2 = aVar.kRu;
            String str3 = aVar.kRv;
            c.a aVar2 = new c.a(this.eEl);
            aVar2.abu(str);
            aVar2.abx(str3).a(new 1(this, aVar));
            aVar2.aby(str2);
            aVar2.anj().show();
        } else if ((obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
            Toast.makeText(this.eEl, obj.toString(), 1).show();
        }
    }
}

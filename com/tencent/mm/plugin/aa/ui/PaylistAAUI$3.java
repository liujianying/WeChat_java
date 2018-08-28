package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class PaylistAAUI$3 implements a {
    final /* synthetic */ PaylistAAUI eEl;

    PaylistAAUI$3(PaylistAAUI paylistAAUI) {
        this.eEl = paylistAAUI;
    }

    public final void bd(Object obj) {
        x.i("MicroMsg.PaylistAAUI", "close pay list failed: %s", new Object[]{obj});
        if (PaylistAAUI.d(this.eEl) != null) {
            PaylistAAUI.d(this.eEl).dismiss();
        }
        if (obj instanceof String) {
            Toast.makeText(this.eEl, obj.toString(), 1).show();
        } else {
            Toast.makeText(this.eEl, i.close_paylist_failed, 1).show();
        }
    }
}

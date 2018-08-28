package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class PaylistAAUI$6 implements a<Void, Boolean> {
    final /* synthetic */ PaylistAAUI eEl;

    PaylistAAUI$6(PaylistAAUI paylistAAUI) {
        this.eEl = paylistAAUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        Boolean bool = (Boolean) obj;
        if (PaylistAAUI.d(this.eEl) != null) {
            PaylistAAUI.d(this.eEl).dismiss();
        }
        if (bool.booleanValue()) {
            x.i("MicroMsg.PaylistAAUI", "urgeAAPay success");
            Toast.makeText(this.eEl, i.urge_aa_success, 1).show();
        } else {
            x.i("MicroMsg.PaylistAAUI", "urgeAAPay fail");
            Toast.makeText(this.eEl, i.urge_aa_failed, 1).show();
        }
        return uQG;
    }
}

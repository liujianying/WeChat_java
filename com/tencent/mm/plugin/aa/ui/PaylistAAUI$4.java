package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class PaylistAAUI$4 implements a<Void, Boolean> {
    final /* synthetic */ PaylistAAUI eEl;

    PaylistAAUI$4(PaylistAAUI paylistAAUI) {
        this.eEl = paylistAAUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        x.i("MicroMsg.PaylistAAUI", "close pay list success: %s", new Object[]{(Boolean) obj});
        if (PaylistAAUI.d(this.eEl) != null) {
            PaylistAAUI.d(this.eEl).dismiss();
        }
        PaylistAAUI.b(this.eEl, null);
        PaylistAAUI.j(this.eEl);
        this.eEl.mController.removeAllOptionMenu();
        PaylistAAUI.k(this.eEl);
        return uQG;
    }
}

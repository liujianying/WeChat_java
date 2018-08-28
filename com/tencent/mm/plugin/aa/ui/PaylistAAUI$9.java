package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class PaylistAAUI$9 implements a {
    final /* synthetic */ PaylistAAUI eEl;

    PaylistAAUI$9(PaylistAAUI paylistAAUI) {
        this.eEl = paylistAAUI;
    }

    public final void bd(Object obj) {
        x.i("MicroMsg.PaylistAAUI", "onInterrupt: %s", new Object[]{obj});
        PaylistAAUI.a(this.eEl, obj == null ? "" : obj.toString());
    }
}

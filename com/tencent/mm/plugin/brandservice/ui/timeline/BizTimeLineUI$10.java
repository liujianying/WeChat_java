package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;

class BizTimeLineUI$10 implements Runnable {
    final /* synthetic */ q her;
    final /* synthetic */ BizTimeLineUI hst;

    BizTimeLineUI$10(BizTimeLineUI bizTimeLineUI, q qVar) {
        this.hst = bizTimeLineUI;
        this.her = qVar;
    }

    public final void run() {
        BizTimeLineUI.c(this.hst).hqO = false;
        int max = Math.max(0, BizTimeLineUI.d(this.hst).getFirstVisiblePosition() - BizTimeLineUI.d(this.hst).getHeaderViewsCount());
        BizTimeLineUI.c(this.hst).a(this.her);
        BizTimeLineUI.c(this.hst).a(BizTimeLineUI.c(this.hst).nz(max));
        x.i("MicroMsg.BizTimeLineUI", "resetKeep pos %d", new Object[]{Integer.valueOf(max)});
    }
}

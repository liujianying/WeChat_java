package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements Runnable {
    final /* synthetic */ c kob;

    c$3(c cVar) {
        this.kob = cVar;
    }

    public final void run() {
        if (!i.aXt().aXm()) {
            x.i("MicroMsg.IPCallManager", "timeout! still not accept!");
            if (this.kob.cK(9, 12)) {
                this.kob.d(9, null, ad.getContext().getString(R.l.callout_failed_network), 2);
            }
        }
    }
}

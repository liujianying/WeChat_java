package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class d$1 implements Runnable {
    final /* synthetic */ d iVC;

    d$1(d dVar) {
        this.iVC = dVar;
    }

    public final void run() {
        ((ae) g.n(ae.class)).getFavItemInfoStorage().aLI();
        d.a(this.iVC, System.currentTimeMillis());
        x.d("MicroMsg.FavCleanFirstLoader", "calDataBaseDataTotalLength, used: %dms", new Object[]{Long.valueOf(d.a(this.iVC) - d.b(this.iVC))});
        d.a(this.iVC, -1);
        d.c(this.iVC);
        synchronized (d.d(this.iVC)) {
            g.Ei().DT().a(a.sRp, Boolean.valueOf(true));
            d.e(this.iVC);
        }
        this.iVC.mHandler.sendEmptyMessage(0);
    }
}

package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class ac$1 implements Runnable {
    final /* synthetic */ boolean fgE;

    ac$1(boolean z) {
        this.fgE = z;
    }

    public final void run() {
        if (this.fgE) {
            x.i("MicroMsg.WxaCommLibVersionChecker", "cgiCheckUpdate, force true");
            g.Ei().DT().a(a.sTu, Long.valueOf(bi.VE() - 1));
        }
        ac.yT();
    }
}

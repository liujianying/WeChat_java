package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.compatible.e.w;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

final class p {
    public static void ccG() {
        if (g.Eg().Dx()) {
            g.Eg();
            if (!a.Dr() && getNetworkType() != 0) {
                long VE = bi.VE();
                if (bi.a((Long) g.Ei().DT().get(aa.a.sRI, null), 0) < VE) {
                    g.Ei().DT().a(aa.a.sRI, Long.valueOf(7200 + VE));
                    x.i("MicroMsg.PostTaskCheckResume", "doCheckResume");
                    q.a.ccH().Em().H(new 1());
                }
            }
        }
    }

    static int getNetworkType() {
        switch (w.zQ()) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return 2;
        }
    }
}

package com.tencent.mm.plugin.appbrand.task;

import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;

class d$3 implements Runnable {
    d$3() {
    }

    public final void run() {
        if (ad.cie()) {
            a.sFg.b(d.anc());
        } else {
            d.amY();
        }
        d.Jv();
    }
}

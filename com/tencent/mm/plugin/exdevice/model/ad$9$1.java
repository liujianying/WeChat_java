package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.f.a.h;
import com.tencent.mm.plugin.exdevice.model.ad.9;

class ad$9$1 implements Runnable {
    final /* synthetic */ Object gYA;
    final /* synthetic */ 9 iwA;

    ad$9$1(9 9, Object obj) {
        this.iwA = 9;
        this.gYA = obj;
    }

    public final void run() {
        String str = (String) this.gYA;
        if (ad.aHg().Af(str)) {
            au.HU();
            if (!c.FR().Yc(str)) {
                au.DF().a(new h(str, null), 0);
            }
        }
    }
}

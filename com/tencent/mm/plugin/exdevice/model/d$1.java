package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.sdk.platformtools.ad;

class d$1 implements c$a {
    final /* synthetic */ d itl;

    d$1(d dVar) {
        this.itl = dVar;
    }

    public final void aGL() {
        if (d.a(this.itl) == null) {
            d.a(this.itl, new c());
            d.a(this.itl).iyE = null;
        }
        d.a(this.itl).dd(ad.getContext());
    }
}

package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

class c$9 implements a {
    final /* synthetic */ c kJf;

    c$9(c cVar) {
        this.kJf = cVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        if (c.g(this.kJf) == -85.0d || c.h(this.kJf) == -1000.0d) {
            x.d("MicroMsg.MMPoiMapUI", "first get location");
            g.Ei().DT().a(aa.a.USERINFO_LAST_LOCATION_STRING, ((int) (1000000.0f * f2)) + "," + ((int) (1000000.0f * f)));
            c.c(this.kJf, (double) f2);
            c.d(this.kJf, (double) f);
            c.a(this.kJf, f2);
            c.b(this.kJf, f);
            c.a(this.kJf, c.g(this.kJf));
            c.b(this.kJf, c.h(this.kJf));
            c.k(this.kJf).m(c.i(this.kJf), c.j(this.kJf));
            this.kJf.kFl.getIController().animateTo(c.g(this.kJf), c.h(this.kJf), d.aZx());
            if (!c.q(this.kJf)) {
                c.m(this.kJf);
            }
        }
        return true;
    }
}

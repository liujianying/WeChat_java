package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class r$3 implements a {
    final /* synthetic */ r oNq;

    r$3(r rVar) {
        this.oNq = rVar;
    }

    public final boolean vD() {
        x.v("MicroMsg.Voip.VoipService", "voip repeat check is foreground");
        if (r.b(this.oNq) == null) {
            r.c(this.oNq);
            r.d(this.oNq).SO();
            return false;
        } else if (r.el(ad.getContext())) {
            this.oNq.O(r.b(this.oNq).rxG, r.b(this.oNq).rxH);
            this.oNq.a(r.b(this.oNq));
            r.e(this.oNq);
            r.c(this.oNq);
            r.d(this.oNq).SO();
            h.mEJ.a(500, 5, 1, false);
            return false;
        } else if (System.currentTimeMillis() - r.f(this.oNq) < 60000) {
            return true;
        } else {
            r.e(this.oNq);
            r.c(this.oNq);
            r.d(this.oNq).SO();
            return false;
        }
    }
}

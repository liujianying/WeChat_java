package com.tencent.mm.ui.conversation;

import com.tencent.mm.aa.q;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.x;

class j$10 implements Runnable {
    final /* synthetic */ j ure;

    j$10(j jVar) {
        this.ure = jVar;
    }

    public final void run() {
        a c = j.c(this.ure);
        x.i("MicroMsg.BannerHelper", "releaseBanner");
        a.dZ(c.una);
        a.dZ(c.unb);
        a.dZ(c.unc);
        a.dZ(c.und);
        for (b bVar : c.une) {
            if (bVar != null) {
                bVar.release();
            }
        }
        if (au.HX()) {
            q.Kp().e(c);
        }
        if (au.HX()) {
            au.HU();
            c.DT().b(c);
        }
    }
}

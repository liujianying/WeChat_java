package com.tencent.mm.ui.conversation;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class j$2 implements Runnable {
    final /* synthetic */ j ure;

    j$2(j jVar) {
        this.ure = jVar;
    }

    public final void run() {
        a c = j.c(this.ure);
        x.i("MicroMsg.BannerHelper", "destroyBanner");
        a.ea(c.una);
        a.ea(c.unb);
        a.ea(c.unc);
        a.ea(c.und);
        for (b bVar : c.une) {
            if (bVar != null) {
                bVar.destroy();
            }
        }
        au.b(c.mHI);
        a.sFg.c(c.unf);
        a.sFg.c(c.ung);
        if (au.HX()) {
            au.HU();
            c.b(c);
        }
        c.context = null;
    }
}

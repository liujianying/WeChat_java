package com.tencent.mm.ui.conversation;

import android.widget.ListView;
import com.tencent.mm.plugin.appbrand.jsapi.p.h;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public final class k {
    d hLH = new d(new 1(this));
    g unL;
    ListView unh;
    boolean urj = false;
    private ah urk;
    private Runnable urm;
    int urn = -1;

    static /* synthetic */ void a(k kVar, int i) {
        if (i < 0) {
            i = h.CTRL_INDEX;
        }
        kVar.czb();
        if (kVar.urk == null) {
            kVar.urk = new ah("pre load mainui avatar");
        }
        kVar.urj = false;
        ah ahVar = kVar.urk;
        3 3 = new 3(kVar);
        kVar.urm = 3;
        ahVar.h(3, (long) i);
    }

    final void czb() {
        if (!this.urj) {
            x.d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
            this.urj = true;
        }
        if (this.urk != null && this.urm != null) {
            this.urk.cil().removeCallbacks(this.urm);
        }
    }
}

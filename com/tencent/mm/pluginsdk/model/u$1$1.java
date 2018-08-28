package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.pluginsdk.model.u.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.x5.sdk.d.a;

class u$1$1 implements a {
    final /* synthetic */ 1 qzy;

    u$1$1(1 1) {
        this.qzy = 1;
    }

    public final void onViewInitFinished(boolean z) {
        x.i("MicroMsg.TBSHelper", "tbs preInit callback, %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            u.fA(this.qzy.ewx, this.qzy.qzx);
        } else {
            u.fz(this.qzy.ewx, this.qzy.qzx);
        }
    }
}

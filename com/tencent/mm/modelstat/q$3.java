package com.tencent.mm.modelstat;

import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.x;

class q$3 extends a {
    final /* synthetic */ q elb;

    q$3(q qVar) {
        this.elb = qVar;
    }

    public final void ev(int i) {
        if (i == 4 || i == 6) {
            g.Em().h(new 1(this), 3000);
            x.d("MicroMsg.SubCoreStat", "NetTypeReporter st:%d", new Object[]{Integer.valueOf(i)});
            o.iw(2);
        }
    }
}

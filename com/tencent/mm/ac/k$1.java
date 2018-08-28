package com.tencent.mm.ac;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements b {
    final /* synthetic */ k dMr;

    k$1(k kVar) {
        this.dMr = kVar;
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.i("MicroMsg.ReportLocation", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        } else if (this.dMr.userName.equals((String) obj) && this.dMr.dMl == 1) {
            x.i("MicroMsg.ReportLocation", "contactStgUpdate, %s", new Object[]{this.dMr.userName});
            this.dMr.kT(this.dMr.userName);
            ((i) g.l(i.class)).FR().b(this.dMr.dMq);
        }
    }
}

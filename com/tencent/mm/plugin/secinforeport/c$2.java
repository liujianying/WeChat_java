package com.tencent.mm.plugin.secinforeport;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements a {
    final /* synthetic */ c mOq;
    final /* synthetic */ int mOr;

    c$2(c cVar, int i) {
        this.mOq = cVar;
        this.mOr = i;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.SecInfoReporterImpl", "cgireport succ, ctx: %d", new Object[]{Integer.valueOf(this.mOr)});
            f.mDy.a(416, 1, 1, false);
        } else {
            x.w("MicroMsg.SecInfoReporterImpl", "cgireport failed, ctx: %d, err: %d:%d %s", new Object[]{Integer.valueOf(this.mOr), Integer.valueOf(i), Integer.valueOf(i2), str});
            f.mDy.a(416, 2, 1, false);
        }
        return 0;
    }
}

package com.tencent.mm.plugin.ext;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;

class b$10 implements b {
    final /* synthetic */ b iJo;

    b$10(b bVar) {
        this.iJo = bVar;
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        } else if (au.HX()) {
            au.HU();
            if (mVar == c.FR()) {
                b.d(this.iJo);
            }
        } else {
            x.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
        }
    }
}

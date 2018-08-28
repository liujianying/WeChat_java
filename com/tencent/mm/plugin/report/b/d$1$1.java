package com.tencent.mm.plugin.report.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.report.b.d.1;
import com.tencent.mm.sdk.platformtools.x;

class d$1$1 implements a {
    final /* synthetic */ 1 mDO;

    d$1$1(1 1) {
        this.mDO = 1;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.i("MicroMsg.MidHelper", "onGYNetEnd errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        return 0;
    }
}

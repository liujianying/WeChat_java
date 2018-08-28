package com.tencent.mm.plugin.mall.a;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;

class d$2 implements a {
    final /* synthetic */ d kYk;

    d$2(d dVar) {
        this.kYk = dVar;
    }

    public final void a(d.a aVar) {
        x.d("MicroMsg.SubCoreMall", "receive pay msg: %s", new Object[]{ab.a(aVar.dIN.rcl)});
        d.a(this.kYk).post(new 1(this, r0));
    }
}

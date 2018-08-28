package com.tencent.mm.plugin.mall.a;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements a {
    final /* synthetic */ d kYk;

    d$1(d dVar) {
        this.kYk = dVar;
    }

    public final void a(d.a aVar) {
        String a = ab.a(aVar.dIN.rcl);
        x.d("MicroMsg.SubCoreMall", "WalletNotifyConfXml:" + a);
        d.a(this.kYk).post(new 1(this, a));
    }
}

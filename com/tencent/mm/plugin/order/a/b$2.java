package com.tencent.mm.plugin.order.a;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements a {
    final /* synthetic */ b lNo;

    b$2(b bVar) {
        this.lNo = bVar;
    }

    public final void a(d.a aVar) {
        String a = ab.a(aVar.dIN.rcl);
        x.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:" + a);
        b.a(this.lNo).post(new 1(this, a));
    }
}

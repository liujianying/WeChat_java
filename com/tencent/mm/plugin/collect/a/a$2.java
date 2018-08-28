package com.tencent.mm.plugin.collect.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements e {
    final /* synthetic */ a hTG;

    a$2(a aVar) {
        this.hTG = aVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        g.Ek();
        g.Eh().dpP.b(304, this);
        if (i != 0 || i2 != 0) {
            x.i("MicroMsg.SubCoreCollect", "set sound fail!");
        }
    }
}

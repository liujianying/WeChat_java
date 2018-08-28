package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.c.a.a;
import com.tencent.mm.plugin.ext.c.e.2;
import com.tencent.mm.sdk.platformtools.x;

class e$2$1 implements e {
    final /* synthetic */ 2 iKV;

    e$2$1(2 2) {
        this.iKV = 2;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ExtQrCodeHandler", "hy: check url done. errType: %d, errCode: %d, errMsg %s, scene: %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(((a) lVar).iKY == 0)});
        g.Eh().dpP.b(782, this);
        if (i == 0 && i2 == 0) {
            this.iKV.cf(Boolean.valueOf(r0));
        } else {
            this.iKV.cf(Boolean.valueOf(false));
        }
    }
}

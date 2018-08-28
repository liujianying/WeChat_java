package com.tencent.mm.plugin.translate.a;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements a {
    final /* synthetic */ d oEE;

    d$1(d dVar) {
        this.oEE = dVar;
    }

    public final boolean vD() {
        if (this.oEE.oEA) {
            x.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", new Object[]{Integer.valueOf(this.oEE.index)});
            this.oEE.bIS();
            this.oEE.oEC.a(-1, this.oEE.oEz, null);
        }
        return false;
    }
}

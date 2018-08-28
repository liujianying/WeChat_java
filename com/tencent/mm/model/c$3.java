package com.tencent.mm.model;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.c.b;

class c$3 implements f {
    final /* synthetic */ c dAk;

    c$3(c cVar) {
        this.dAk = cVar;
    }

    public final void Ep() {
        au.HT();
    }

    public final void gj(String str) {
        if (com.tencent.mm.compatible.util.f.zZ()) {
            g.Ek();
            if (g.Ei().dqo.equals(e.bnE)) {
                g.Ek();
                com.tencent.mm.sdk.f.e.post(new b(g.Ei().cachePath, str), "AccountStorage_moveDataFiles");
            }
        }
    }
}

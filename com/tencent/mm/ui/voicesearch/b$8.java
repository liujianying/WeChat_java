package com.tencent.mm.ui.voicesearch;

import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.b.b;

class b$8 implements b {
    final /* synthetic */ b uFM;

    b$8(b bVar) {
        this.uFM = bVar;
    }

    public final String jd(int i) {
        if (i < 0) {
            x.e("MicroMsg.SearchResultAdapter", "pos is invalid");
            return null;
        }
        biy Gk = this.uFM.Gk((b.e(this.uFM) + i) + 1);
        if (Gk != null) {
            return Gk.rvi.siM;
        }
        return null;
    }

    public final int Xy() {
        return b.f(this.uFM) == null ? 0 : b.f(this.uFM).size();
    }
}

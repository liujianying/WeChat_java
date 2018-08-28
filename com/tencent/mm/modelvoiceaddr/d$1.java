package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements a {
    final /* synthetic */ d eqq;

    d$1(d dVar) {
        this.eqq = dVar;
    }

    public final boolean vD() {
        long cm = (long) e.cm(this.eqq.filename);
        x.d("MicroMsg.NetSceneVoiceInput", g.Ac() + " onTimerExpired: file:" + this.eqq.filename + " nowlen:" + cm + " oldoff:" + this.eqq.ehi + " isFin:" + this.eqq.eoE);
        if (cm - ((long) this.eqq.ehi) < 3300 && !this.eqq.eoE) {
            return true;
        }
        if (this.eqq.a(this.eqq.dIX, this.eqq.diJ) == -1) {
            this.eqq.retCode = g.getLine() + 40000;
            this.eqq.diJ.a(3, -1, "doScene failed", this.eqq);
        }
        return false;
    }
}

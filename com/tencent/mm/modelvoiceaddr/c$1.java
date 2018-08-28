package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c eqo;

    c$1(c cVar) {
        this.eqo = cVar;
    }

    public final boolean vD() {
        long cm = (long) e.cm(this.eqo.filename);
        x.d("MicroMsg.NetSceneVoiceAddr", g.Ac() + " onTimerExpired: file:" + this.eqo.filename + " nowlen:" + cm + " oldoff:" + this.eqo.ehi + " isFin:" + this.eqo.eoE);
        if (cm - ((long) this.eqo.ehi) < 3300 && !this.eqo.eoE) {
            return true;
        }
        if (this.eqo.a(this.eqo.dIX, this.eqo.diJ) == -1) {
            this.eqo.retCode = g.getLine() + 40000;
            this.eqo.diJ.a(3, -1, "doScene failed", this.eqo);
        }
        return false;
    }
}

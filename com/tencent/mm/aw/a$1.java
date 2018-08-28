package com.tencent.mm.aw;

import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    final /* synthetic */ a ehk;

    a$1(a aVar) {
        this.ehk = aVar;
    }

    public final boolean vD() {
        x.d("MicroMsg.NetSceneUploadMedia", g.Ac() + " onTimerExpired: file:" + this.ehk.filename + " nowlen:" + ((long) e.cm(this.ehk.filename)) + " oldoff:" + this.ehk.ehi);
        if (this.ehk.a(this.ehk.dIX, this.ehk.diJ) == -1) {
            this.ehk.diJ.a(3, -1, "doScene failed", this.ehk);
        }
        return false;
    }
}

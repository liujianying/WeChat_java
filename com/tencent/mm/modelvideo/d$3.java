package com.tencent.mm.modelvideo;

import com.tencent.mm.sdk.platformtools.al.a;

class d$3 implements a {
    final /* synthetic */ d emc;

    d$3(d dVar) {
        this.emc = dVar;
    }

    public final boolean vD() {
        if (this.emc.a(this.emc.dIX, this.emc.diJ) == -1) {
            this.emc.diJ.a(3, -1, "doScene failed", this.emc);
        }
        return false;
    }
}

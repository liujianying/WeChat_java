package com.tencent.mm.plugin.i;

import com.tencent.mm.an.b;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bi;

public final class e extends a {
    private ak dBw;

    static /* synthetic */ boolean atZ() {
        if (b.PY()) {
            return false;
        }
        rn rnVar = new rn();
        rnVar.ccn.ccp = true;
        com.tencent.mm.sdk.b.a.sFg.m(rnVar);
        return bi.oW(rnVar.cco.ccr);
    }

    public e(ak akVar) {
        this.dBw = akVar;
    }

    public final void execute(g gVar) {
        au.a(this.dBw, new 1(this));
    }
}

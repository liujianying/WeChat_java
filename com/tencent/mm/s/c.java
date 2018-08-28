package com.tencent.mm.s;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class c implements ar {
    private static c dlL;
    private a dlM;

    private c() {
        if (a.dlr == null) {
            a.dlr = new a();
        }
        this.dlM = a.dlr;
    }

    public final void onAccountRelease() {
        a aVar = this.dlM;
        aVar.dlt.clear();
        b bVar = aVar.dls;
        x.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
        bVar.dlB.clear();
        bVar.dlD.clear();
        bVar.dlC.clear();
        bVar.dlE.clear();
        aVar.initialized = false;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        this.dlM.init();
    }

    public final void bo(boolean z) {
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public static a Cp() {
        g.Eg().Ds();
        if (dlL == null) {
            c cVar = new c();
            dlL = cVar;
            cVar.dlM.init();
        }
        return dlL.dlM;
    }
}

package com.tencent.mm.plugin.auto.a;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class b implements ar {
    private a gRh = new a();

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.auto.SubCoreAuto", "onAccountPostReset");
        a.sFg.b(this.gRh.gRf);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.auto.SubCoreAuto", "onAccountRelease");
        a.sFg.c(this.gRh.gRf);
    }
}

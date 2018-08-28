package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.brandservice.ui.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class c implements ar {
    private a hnG;

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
        x.d("MicroMsg.BrandService.SubCoreBrandService", "on sub core brand service reset");
        if (this.hnG == null) {
            this.hnG = new a();
        }
        a.sFg.b(this.hnG);
        ((n) g.n(n.class)).registerFTSUILogic(new com.tencent.mm.plugin.brandservice.ui.a.d());
        ((n) g.n(n.class)).registerFTSUILogic(new b());
    }

    public final void onAccountRelease() {
        if (this.hnG != null) {
            a.sFg.c(this.hnG);
        }
        ((n) g.n(n.class)).unregisterFTSUILogic(96);
        ((n) g.n(n.class)).unregisterFTSUILogic(4208);
    }
}

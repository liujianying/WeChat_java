package com.tencent.mm.plugin.favorite;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class f implements ar {
    private c jfX = new 1(this);

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.Fav.SubCoreFav", "onAccountPostReset updated:%b", new Object[]{Boolean.valueOf(z)});
        a.sFg.a(this.jfX);
        g.a(y.class, new c());
        g.a(ab.class, new e());
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        a.sFg.c(this.jfX);
        ((n) g.n(n.class)).unregisterFTSUILogic(128);
        ((n) g.n(n.class)).unregisterFTSUILogic(4192);
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }
}

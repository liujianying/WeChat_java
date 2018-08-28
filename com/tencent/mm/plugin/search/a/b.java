package com.tencent.mm.plugin.search.a;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.search.b.a.a.a;
import java.util.HashMap;

public final class b implements ar {
    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
        ((n) g.n(n.class)).registerItemClickHandler(3, new a());
        ((n) g.n(n.class)).registerItemClickHandler(6, new com.tencent.mm.plugin.search.b.a.a.b());
    }

    public final void onAccountRelease() {
        ((n) g.n(n.class)).unregisterItemClickHandler(3);
        ((n) g.n(n.class)).unregisterItemClickHandler(6);
    }
}

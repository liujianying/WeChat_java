package com.tencent.mm.plugin.wallet_index.a;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.wallet_index.c.h;
import java.util.HashMap;

public class a implements ar {
    private h pCC = new h();

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
        com.tencent.mm.sdk.b.a.sFg.b(this.pCC.pCW);
        com.tencent.mm.sdk.b.a.sFg.b(this.pCC.pCX);
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.sFg.c(this.pCC.pCW);
        com.tencent.mm.sdk.b.a.sFg.c(this.pCC.pCX);
    }
}

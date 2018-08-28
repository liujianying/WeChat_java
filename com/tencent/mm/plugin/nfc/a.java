package com.tencent.mm.plugin.nfc;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import java.util.HashMap;

public final class a implements ar {
    private static com.tencent.mm.plugin.hce.a.a lEU = new com.tencent.mm.plugin.hce.a.a();

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
        if (!com.tencent.mm.sdk.b.a.sFg.d(lEU)) {
            com.tencent.mm.sdk.b.a.sFg.a(lEU);
        }
    }

    public final void onAccountRelease() {
        if (com.tencent.mm.sdk.b.a.sFg.d(lEU)) {
            com.tencent.mm.sdk.b.a.sFg.c(lEU);
        }
    }
}

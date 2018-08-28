package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public final class SubCoreGameCenter implements ar {
    private c bannerOnInitListener = new 2(this);
    private c jOF = new 1(this);
    private c jOG = new 3(this);

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        a.sFg.b(this.jOF);
        a.sFg.b(this.bannerOnInitListener);
        a.sFg.b(this.jOG);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        a.sFg.c(this.jOF);
        a.sFg.c(this.bannerOnInitListener);
        a.sFg.c(this.jOG);
    }
}

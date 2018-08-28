package com.tencent.mm.plugin.radar;

import b.c.b.e;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.radar.a.a;
import com.tencent.mm.sdk.platformtools.x;

public final class PluginRadar extends f implements a {
    private static final String TAG = TAG;
    public static final a mjj = new a((byte) 0);

    public final void configure(g gVar) {
        e.i(gVar, "profile");
        if (gVar.ES()) {
            x.i(TAG, "PluginRadar configure");
            pin((c) new p(c.class));
        }
    }

    public final void execute(g gVar) {
        e.i(gVar, "profile");
        com.tencent.mm.bg.c.Um("radar");
    }
}

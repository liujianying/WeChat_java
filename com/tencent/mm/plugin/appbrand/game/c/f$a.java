package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.mm.sdk.platformtools.al.a;

class f$a implements a {
    final /* synthetic */ f fBS;

    private f$a(f fVar) {
        this.fBS = fVar;
    }

    public /* synthetic */ f$a(f fVar, byte b) {
        this(fVar);
    }

    public final boolean vD() {
        synchronized (this.fBS) {
            this.fBS.fBQ = (int) Math.round(this.fBS.fBP.ami());
        }
        return true;
    }
}

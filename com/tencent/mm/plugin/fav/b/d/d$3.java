package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class d$3 implements a {
    final /* synthetic */ d iXP;

    d$3(d dVar) {
        this.iXP = dVar;
    }

    public final boolean vD() {
        try {
            d.d(this.iXP);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Fav.FavModService", e, "", new Object[0]);
        }
        return false;
    }

    public final String toString() {
        return super.toString() + "|scenePusher";
    }
}

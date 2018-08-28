package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class a$5 implements a {
    final /* synthetic */ a iXG;

    a$5(a aVar) {
        this.iXG = aVar;
    }

    public final boolean vD() {
        try {
            this.iXG.OI();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
        }
        return false;
    }

    public final String toString() {
        return super.toString() + "|scenePusher";
    }
}

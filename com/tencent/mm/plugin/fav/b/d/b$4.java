package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class b$4 implements a {
    final /* synthetic */ b iXK;

    b$4(b bVar) {
        this.iXK = bVar;
    }

    public final boolean vD() {
        try {
            b.b(this.iXK);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", e, "", new Object[0]);
        }
        return false;
    }

    public final String toString() {
        return super.toString() + "|scenePusher";
    }
}

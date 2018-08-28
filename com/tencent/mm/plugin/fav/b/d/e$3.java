package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class e$3 implements a {
    final /* synthetic */ e iXR;

    e$3(e eVar) {
        this.iXR = eVar;
    }

    public final boolean vD() {
        try {
            e.d(this.iXR);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Fav.FavSendService", e, "", new Object[0]);
        }
        return false;
    }

    public final String toString() {
        return super.toString() + "|scenePusher";
    }
}

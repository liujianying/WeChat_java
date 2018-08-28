package com.tencent.mm.plugin.game.wepkg;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements a {
    final /* synthetic */ a kdP;

    a$3(a aVar) {
        this.kdP = aVar;
    }

    public final boolean vD() {
        if (a.c(this.kdP).aTc()) {
            a.a(this.kdP, 0);
        } else {
            x.i("MicroMsg.Wepkg.WePkgPlugin", "white screen");
            ah.A(new 1(this));
        }
        return false;
    }
}

package com.tencent.mm.plugin.voip.widget;

import com.tencent.mm.plugin.voip.widget.b.1;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1$1 implements a {
    final /* synthetic */ 1 oWi;

    b$1$1(1 1) {
        this.oWi = 1;
    }

    public final boolean vD() {
        x.i("MicroMsg.Voip.VoipSmallWindow", "click small view and time is up we remove it..");
        b.b(this.oWi.oWh);
        if (b.c(this.oWi.oWh) != null) {
            b.c(this.oWi.oWh).SO();
        }
        return true;
    }
}

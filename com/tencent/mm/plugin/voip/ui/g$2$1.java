package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.plugin.voip.ui.g.2;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class g$2$1 implements a {
    final /* synthetic */ 2 oSS;

    g$2$1(2 2) {
        this.oSS = 2;
    }

    public final boolean vD() {
        x.i("MicroMsg.VoipVoiceMiniManager", "click small view and time is up we remove it..");
        this.oSS.oSR.dismiss();
        if (this.oSS.oSR.oSP != null) {
            this.oSS.oSR.oSP.SO();
        }
        return true;
    }
}

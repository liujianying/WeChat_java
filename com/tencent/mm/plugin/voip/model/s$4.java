package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class s$4 implements a {
    final /* synthetic */ s oNG;

    s$4(s sVar) {
        this.oNG = sVar;
    }

    public final boolean vD() {
        x.i("MicroMsg.Voip.VoipServiceEx", "voip called out of time,now destroy...");
        if (3 == this.oNG.oHa.mStatus && s.d(this.oNG) != 0 && s.d(this.oNG) == this.oNG.oHa.oJX.kpo) {
            s.e(this.oNG);
            this.oNG.oHa.o(5, -9000, "");
        }
        return false;
    }
}

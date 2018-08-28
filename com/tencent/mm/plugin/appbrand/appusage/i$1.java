package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.al.a;

class i$1 implements a {
    final /* synthetic */ PBool flF;
    final /* synthetic */ PBool flG;

    i$1(PBool pBool, PBool pBool2) {
        this.flF = pBool;
        this.flG = pBool2;
    }

    public final boolean vD() {
        if (!this.flF.value) {
            this.flG.value = true;
            i.a(null);
        }
        return false;
    }
}

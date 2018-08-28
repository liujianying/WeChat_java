package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;

class k$5 implements a {
    final /* synthetic */ k kGI;

    k$5(k kVar) {
        this.kGI = kVar;
    }

    public final boolean vD() {
        int So;
        if (this.kGI.kGy == 3) {
            So = this.kGI.kGE.So();
        } else if (bi.oW(this.kGI.kGv)) {
            return false;
        } else {
            So = this.kGI.kGE.Sp();
        }
        k kVar = this.kGI;
        float f = (float) So;
        if (f < 10.0f) {
            f = 10.0f;
        }
        if (f > 100.0f) {
            f = 100.0f;
        }
        kVar.kGr.setVolume(f / 100.0f);
        kVar.kGr.invalidate();
        return true;
    }
}

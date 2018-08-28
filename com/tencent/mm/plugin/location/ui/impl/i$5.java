package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.x;

class i$5 implements a {
    final /* synthetic */ i kKy;

    i$5(i iVar) {
        this.kKy = iVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        x.d("MicroMsg.ViewMapUI", "onGetLocation flong " + f + " flat " + f2);
        if (((double) f2) == 0.0d && ((double) f) == 0.0d) {
            return true;
        }
        x.d("MicroMsg.ViewMapUI", "myLocation " + this.kKy.kHQ.kCw + " " + this.kKy.kHQ.kCx);
        if (!this.kKy.kHQ.aYY()) {
            x.d("MicroMsg.ViewMapUI", "location my show");
            this.kKy.kHQ.kCw = (double) f2;
            this.kKy.kHQ.kCx = (double) f;
            this.kKy.kHU.a(this.kKy.kHQ.kCw, this.kKy.kHQ.kCx, this.kKy.kIb, this.kKy.kHQ.kCv);
        }
        return true;
    }
}

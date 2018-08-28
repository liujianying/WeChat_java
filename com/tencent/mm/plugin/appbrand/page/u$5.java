package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.sdk.platformtools.bd;

class u$5 extends bd<Boolean> {
    final /* synthetic */ int Xt;
    final /* synthetic */ int fKG;
    final /* synthetic */ u goS;
    final /* synthetic */ float[] goU;
    final /* synthetic */ Boolean goW;

    u$5(u uVar, Boolean bool, int i, float[] fArr, int i2, Boolean bool2) {
        this.goS = uVar;
        this.fKG = i;
        this.goU = fArr;
        this.Xt = i2;
        this.goW = bool2;
        super(1000, bool, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        return Boolean.valueOf(this.goS.b(this.fKG, this.goU, this.Xt, this.goW));
    }
}

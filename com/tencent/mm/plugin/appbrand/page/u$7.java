package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.sdk.platformtools.bd;

class u$7 extends bd<Boolean> {
    final /* synthetic */ int fKG;
    final /* synthetic */ u goS;

    u$7(u uVar, Boolean bool, int i) {
        this.goS = uVar;
        this.fKG = i;
        super(1000, bool, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        return Boolean.valueOf(this.goS.lB(this.fKG));
    }
}

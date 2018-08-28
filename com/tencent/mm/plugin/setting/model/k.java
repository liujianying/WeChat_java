package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.protocal.c.aug;
import com.tencent.mm.protocal.c.sh;
import com.tencent.mm.protocal.c.si;

public final class k extends b {
    private aug mOO;

    public k(boolean z, int i, int i2) {
        int i3 = 1;
        super(31);
        this.mOO = new aug();
        sh shVar = new sh();
        shVar.rvE = z ? 1 : 0;
        if (z) {
            i3 = 0;
        }
        shVar.rvG = i3;
        si siVar = new si();
        siVar.rvI = i;
        siVar.rvJ = i2;
        shVar.rvF = siVar;
        siVar.rvI = 0;
        siVar.rvJ = 0;
        shVar.rvH = siVar;
        this.mOO.rXz = shVar;
        this.lcH = this.mOO;
    }

    public k() {
        this(false, 22, 8);
    }
}

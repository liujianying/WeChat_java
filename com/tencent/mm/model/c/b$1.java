package com.tencent.mm.model.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.protocal.c.yr;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    b$1() {
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        b.Ju();
        if (i == 0 && i2 == 0) {
            yr yrVar = (yr) bVar.dIE.dIL;
            b.access$100();
            b.hm(yrVar.rxy);
            b.hl(yrVar.rEU);
            b.J(yrVar.rEV);
            b.K(yrVar.rET);
            b.Jv();
            x.i("MicroMsg.ABTestUpdater", "Update Interval: %d", Integer.valueOf(yrVar.rEU));
        } else {
            x.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(86400));
            b.access$100();
            b.hl(86400);
            b.Jv();
        }
        return 0;
    }
}

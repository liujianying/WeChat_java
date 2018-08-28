package com.tencent.mm.plugin.welab;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.protocal.c.yr;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements a {
    f$1() {
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (i == 0 && i2 == 0) {
            yr yrVar = (yr) bVar.dIE.dIL;
            f.vg();
            f.Bm(yrVar.rxy);
            f.Bl(yrVar.rEU);
            f.cP(yrVar.rEV);
            f.J(yrVar.rET);
            f.bwD();
            x.i("MicroMsg.WelabUpdater", "Update Interval: %d", new Object[]{Integer.valueOf(yrVar.rEU)});
            f.bYL();
        } else {
            x.e("MicroMsg.WelabUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(86400)});
            f.vg();
            f.Bl(86400);
            f.bwD();
        }
        return 0;
    }
}

package com.tencent.mm.ui.tools;

import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.sdk.platformtools.x;

class MultiStageCitySelectUI$1 implements a {
    final /* synthetic */ MultiStageCitySelectUI uBd;

    MultiStageCitySelectUI$1(MultiStageCitySelectUI multiStageCitySelectUI) {
        this.uBd = multiStageCitySelectUI;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (MultiStageCitySelectUI.a(this.uBd) == null) {
            return false;
        }
        if (z) {
            x.i("MicroMsg.MultiStageCitySelectUI", "lat:%f lng:%f accuracy:%f", new Object[]{Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2)});
            au.DF().a(new j((double) f2, (double) f), 0);
        } else {
            MultiStageCitySelectUI.b(this.uBd);
        }
        if (MultiStageCitySelectUI.a(this.uBd) != null) {
            MultiStageCitySelectUI.a(this.uBd).c(MultiStageCitySelectUI.c(this.uBd));
            MultiStageCitySelectUI.d(this.uBd);
        }
        return false;
    }
}

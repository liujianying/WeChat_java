package com.tencent.mm.booter;

import com.tencent.mm.a.h;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.an.a;
import com.tencent.mm.sdk.platformtools.x;

public final class m {
    public static void run() {
        int i = g.AT().getInt("EnableFlockMultiProcSPProb", 0);
        au.HU();
        int aM = h.aM(c.Df(), 101);
        boolean z = b.chp() || (i > 0 && aM >= 0 && aM <= i);
        a.setValue(a.sHz, z);
        x.i("MicroMsg.PostTaskUpdateMultiProcSPSwitchListener", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", new Object[]{Integer.valueOf(aM), Integer.valueOf(i), Boolean.valueOf(z)});
    }
}

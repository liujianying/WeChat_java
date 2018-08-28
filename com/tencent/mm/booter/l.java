package com.tencent.mm.booter;

import com.tencent.mm.a.h;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.x;

public final class l {
    public static void run() {
        int i = g.AT().getInt("EnableMMBitmapFactoryProb", 0);
        au.HU();
        int aM = h.aM(c.Df(), 100);
        boolean z = b.chp() || (i > 0 && aM >= 0 && aM <= i);
        MMBitmapFactory.setUseMMBitmapFactory(z);
        x.i("MicroMsg.PostTaskUpdateMMImgDecSwitch", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", new Object[]{Integer.valueOf(aM), Integer.valueOf(i), Boolean.valueOf(z)});
    }
}

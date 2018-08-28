package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static volatile boolean fer = false;

    static void aaQ() {
        ah.A(new 1());
    }

    public static void aaR() {
        x.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "setSkipMiscPreload %b", new Object[]{Boolean.valueOf(true)});
        fer = true;
    }
}

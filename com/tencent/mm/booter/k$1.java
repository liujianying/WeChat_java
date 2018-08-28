package com.tencent.mm.booter;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements a {
    k$1() {
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (z) {
            x.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
            k.S(f2);
            k.T(f);
            k.aQ(true);
            if (k.xH() != null) {
                k.xH().c(k.xI());
                k.aQ(false);
            }
        } else {
            x.w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
        }
        return false;
    }
}

package com.tencent.mm.booter;

import com.tencent.mm.app.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements a {
    g$1() {
    }

    public final void et(int i) {
        x.i("MicroMsg.PostTaskLightweightJob", "CrashStatus report: key %s ", new Object[]{Integer.valueOf(i)});
        h.mEJ.a(25, (long) i, 1, false);
    }
}

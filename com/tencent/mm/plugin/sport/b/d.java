package com.tencent.mm.plugin.sport.b;

import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public static final void kB(int i) {
        x.v("MicroMsg.Sport.SportReportLogic", "report action=%d", new Object[]{Integer.valueOf(i)});
        f.mDy.h(13168, new Object[]{Integer.valueOf(i)});
    }
}

package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

final class r {
    static void a(b bVar, String str, int i, int i2, int i3, long j) {
        int vn = a.vn(str);
        x.d("MicroMsg.AppBrand.LaunchStepCostReporter", "report %s | %s | %d | %d | %d", new Object[]{bVar.name(), str, Long.valueOf(j), Integer.valueOf(vn), Integer.valueOf(0)});
        h.mEJ.h(13886, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(bVar.fBN), "", "", Long.valueOf(j), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(vn), Integer.valueOf(0)});
    }
}

package com.tencent.mm.plugin.nfc.b;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static void aa(String str, int i, int i2) {
        x.i("MicroMsg.HCEReportManager", "alvinluo reportStartHCEResult appId: %s, result: %d, diff: %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        h.mEJ.h(14837, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
    }
}

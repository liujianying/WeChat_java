package com.tencent.mm.ui.contact;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

public final class x {
    public static final void n(String str, int i, int i2, int i3) {
        if (!bi.oW(str)) {
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[]{String.format("%s,%d,%d,%d,%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0)})});
            h.mEJ.k(13234, r0);
        }
    }

    public static void FO(int i) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomClick %d %d", new Object[]{Integer.valueOf(13941), Integer.valueOf(i)});
        h.mEJ.h(13941, new Object[]{Integer.valueOf(i)});
    }
}

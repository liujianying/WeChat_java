package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

public final class y implements e {
    public y() {
        g.DF().a(1223, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
    }

    public static void b(String str, int i, int i2, String str2, String str3) {
        x.i("MicroMsg.GameMsgReportService", "appId = %s, opType = %d, opStatus = %d, extInfo = %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str3});
        g.DF().a(new bb(str, i, i2, str2, str3), 0);
    }
}

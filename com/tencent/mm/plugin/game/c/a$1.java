package com.tencent.mm.plugin.game.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.i("MicroMsg.ReportDownloadAppState", "doCgi, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        return 0;
    }
}

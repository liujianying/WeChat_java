package com.tencent.mm.plugin.monitor;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements e {
    final /* synthetic */ b lsb;

    b$1(b bVar) {
        this.lsb = bVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        String str2 = "MicroMsg.SubCoreBaseMonitor";
        String str3 = "summerhv onIDKeyCallback onSceneEnd[%d][%d, %d, %s]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(lVar == null ? -1 : lVar.getType());
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = str;
        x.i(str2, str3, objArr);
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.report.service.e.brQ();
        }
    }
}

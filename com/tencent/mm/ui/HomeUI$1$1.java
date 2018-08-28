package com.tencent.mm.ui;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.HomeUI.1;
import com.tencent.mm.vending.c.a;
import java.util.ArrayList;
import java.util.Iterator;

class HomeUI$1$1 implements a<Void, Void> {
    final /* synthetic */ 1 tjT;

    HomeUI$1$1(1 1) {
        this.tjT = 1;
    }

    public final /* synthetic */ Object call(Object obj) {
        ArrayList xh = com.tencent.mm.blink.a.xh();
        ArrayList arrayList = new ArrayList();
        Iterator it = xh.iterator();
        while (it.hasNext()) {
            long[] jArr = (long[]) it.next();
            x.i("MicroMsg.LauncherUI.HomeUI", "blink-startup %s, %s, %s", new Object[]{Long.valueOf(jArr[0]), Long.valueOf(jArr[1]), Long.valueOf(jArr[2])});
            arrayList.add(new IDKey(jArr[0], jArr[1], jArr[2]));
        }
        if (arrayList.size() > 0) {
            h.mEJ.b(arrayList, false);
        }
        x.i("MicroMsg.LauncherUI.HomeUI", "blink-startup report size %s", new Object[]{Integer.valueOf(xh.size())});
        xh.clear();
        return uQG;
    }
}

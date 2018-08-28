package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.database.Cursor;
import com.tencent.mm.ac.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class g$2 implements Runnable {
    final /* synthetic */ g hsc;

    g$2(g gVar) {
        this.hsc = gVar;
    }

    public final void run() {
        int i;
        int i2;
        int axd = z.Nf().axd();
        Cursor b = z.Ne().dCZ.b("SELECT count(*) FROM BizTimeLineInfo where status != 4", null, 0);
        if (b.moveToFirst()) {
            i = b.getInt(0);
        } else {
            i = 0;
        }
        b.close();
        Cursor b2 = z.Ne().dCZ.b("SELECT count(*) FROM BizTimeLineInfo where status != 4 and orderFlag & 4278190080 != 0 ", null, 0);
        if (b2.moveToFirst()) {
            i2 = b2.getInt(0);
        } else {
            i2 = 0;
        }
        b2.close();
        h.mEJ.h(11404, new Object[]{Integer.valueOf(1), Integer.valueOf(axd), Integer.valueOf(i), Integer.valueOf(i2)});
        x.i("MicroMsg.BizTimeLineReport", "reportEnterBiz %d|%d|%d", new Object[]{Integer.valueOf(axd), Integer.valueOf(i), Integer.valueOf(i2)});
    }
}

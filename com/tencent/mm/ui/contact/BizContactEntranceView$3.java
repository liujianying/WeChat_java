package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.ac.e;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class BizContactEntranceView$3 implements Runnable {
    final /* synthetic */ BizContactEntranceView uil;

    BizContactEntranceView$3(BizContactEntranceView bizContactEntranceView) {
        this.uil = bizContactEntranceView;
    }

    public final void run() {
        long j = 0;
        e MY = z.MY();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select updateTime from BizInfo where type = 1");
        stringBuilder.append(" and status = 1 ORDER BY updateTime DESC");
        x.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", new Object[]{stringBuilder.toString()});
        Cursor rawQuery = MY.rawQuery(r1, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
                rawQuery.close();
            } else {
                rawQuery.close();
            }
        }
        au.HU();
        x.i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", new Object[]{Long.valueOf(j), Long.valueOf(bi.ch(c.DT().get(233473, null)))});
        ah.A(new 1(this, j, r4));
    }
}

package com.tencent.mm.ae;

import android.database.Cursor;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends ah {
    public final String getTag() {
        return "MicroMsg.App.SyncTopConversation";
    }

    public final boolean gV(int i) {
        return i != 0 && i < 620758015;
    }

    public final void transfer(int i) {
        x.d("MicroMsg.App.SyncTopConversation", "the previous version is %d", new Object[]{Integer.valueOf(i)});
        h.mEJ.e(336, 15, 1);
        au.HU();
        com.tencent.mm.bt.h FO = c.FO();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select username from rconversation");
        stringBuilder.append(" where flag & 4611686018427387904 != 0");
        x.d("MicroMsg.App.SyncTopConversation", "sql:%s", new Object[]{stringBuilder});
        Cursor b = FO.b(stringBuilder.toString(), null, 2);
        if (b != null) {
            while (b.moveToNext()) {
                x.v("MicroMsg.App.SyncTopConversation", "userName %s", new Object[]{b.getString(0)});
                s.t(r1, false);
            }
            b.close();
        }
    }
}

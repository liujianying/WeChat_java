package com.tencent.mm.plugin.card.c;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements b {
    public final boolean axz() {
        return l.azR();
    }

    public final boolean axA() {
        return l.azT();
    }

    public final String axB() {
        return (String) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sPS, null);
    }

    public final int axC() {
        int i = 0;
        c axi = am.axi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR status=5) and (block_mask= '1' OR block_mask= '0' )");
        Cursor b = axi.diF.b("select count(*) from UserCardInfo" + stringBuilder.toString(), null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            b.close();
        }
        x.i("MicroMsg.CardMgrImpl", "getGiftCardCount:" + i);
        return i;
    }

    public final boolean nI(int i) {
        return l.nI(i);
    }
}

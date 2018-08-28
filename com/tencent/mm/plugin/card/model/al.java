package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class al extends i<ak> {
    public static final String[] diD = new String[]{i.a(ak.dhO, "PendingCardId")};
    e diF;

    public al(e eVar) {
        super(eVar, ak.dhO, "PendingCardId", null);
        this.diF = eVar;
    }

    public final List<ak> axg() {
        List<ak> arrayList = new ArrayList();
        Cursor b = this.diF.b("select * from PendingCardId where retryCount < 10", null, 2);
        while (b.moveToNext()) {
            ak akVar = new ak();
            akVar.d(b);
            arrayList.add(akVar);
        }
        b.close();
        x.d("MicroMsg.PendingCardIdInfoStorage", "getAll, count = %d", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }
}

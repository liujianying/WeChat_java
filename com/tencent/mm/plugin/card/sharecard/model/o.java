package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class o extends i<n> {
    public static final String[] diD = new String[]{i.a(n.dhO, "ShareCardSyncItemInfo")};
    private e diF;

    public o(e eVar) {
        super(eVar, n.dhO, "ShareCardSyncItemInfo", null);
        this.diF = eVar;
    }

    public final List<n> axg() {
        List<n> arrayList = new ArrayList();
        Cursor b = this.diF.b("select * from ShareCardSyncItemInfo where retryCount < 10", null, 2);
        while (b.moveToNext()) {
            n nVar = new n();
            nVar.d(b);
            arrayList.add(nVar);
        }
        b.close();
        x.d("MicroMsg.ShareCardSyncItemInfoStorage", "getAll, share card count = %d", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }
}

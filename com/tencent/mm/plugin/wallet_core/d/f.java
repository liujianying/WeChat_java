package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.ArrayList;

public final class f extends i<x> {
    public static final String[] diD = new String[]{i.a(x.dhO, "WalletKindInfo")};
    public e diF;

    public f(e eVar) {
        super(eVar, x.dhO, "WalletKindInfo", null);
        this.diF = eVar;
    }

    public final ArrayList<x> bPT() {
        ArrayList<x> arrayList = null;
        Cursor b = this.diF.b("select * from WalletKindInfo", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    x xVar = new x();
                    xVar.d(b);
                    arrayList.add(xVar);
                } while (b.moveToNext());
            }
            b.close();
        }
        return arrayList;
    }
}

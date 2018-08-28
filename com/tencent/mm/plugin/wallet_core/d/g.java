package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.HashMap;
import java.util.Map;

public final class g extends i<y> {
    public static final String[] diD = new String[]{i.a(y.dhO, "WalletLuckyMoney")};
    public static Map<String, y> eBb = new HashMap();
    private e diF;

    public g(e eVar) {
        super(eVar, y.dhO, "WalletLuckyMoney", null);
        this.diF = eVar;
    }

    public final y Pk(String str) {
        Cursor rawQuery = this.diF.rawQuery("select * from WalletLuckyMoney where mNativeUrl=?", new String[]{str});
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return null;
        }
        rawQuery.moveToFirst();
        y yVar = new y();
        yVar.d(rawQuery);
        rawQuery.close();
        return yVar;
    }

    public final boolean a(y yVar) {
        if (yVar != null && eBb.containsKey(yVar.field_mNativeUrl)) {
            eBb.put(yVar.field_mNativeUrl, yVar);
        }
        return super.a(yVar);
    }
}

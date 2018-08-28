package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class l extends i<k> {
    public static final String[] diD = new String[]{i.a(k.dhO, "IPCallRecord")};
    public static final String[] ksH = new String[]{"*", "rowid"};
    public e diF;

    public l(e eVar) {
        super(eVar, k.dhO, "IPCallRecord", null);
        this.diF = eVar;
    }

    public final Cursor ET(String str) {
        return this.diF.query("IPCallRecord", ksH, "phonenumber=?", new String[]{str}, null, null, "calltime desc");
    }

    public final Cursor dQ(long j) {
        return this.diF.query("IPCallRecord", ksH, "addressId=?", new String[]{String.valueOf(j)}, null, null, "calltime desc");
    }

    public final void a(k kVar) {
        if (kVar != null) {
            a(kVar.sKx, kVar);
        }
    }
}

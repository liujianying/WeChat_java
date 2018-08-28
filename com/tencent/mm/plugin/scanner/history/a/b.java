package com.tencent.mm.plugin.scanner.history.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class b extends i<a> {
    public static final String[] diD = new String[]{i.a(a.dhO, "ScanHistoryItem")};
    public e diF;

    public b(e eVar) {
        super(eVar, a.dhO, "ScanHistoryItem", null);
        this.diF = eVar;
    }

    public final Cursor axc() {
        return this.diF.rawQuery("select * from ScanHistoryItem order by ScanTime desc", null);
    }
}

package com.tencent.mm.plugin.appbrand.appcache.a.d;

import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d extends c<c> {
    public static final String[] dzV = new String[]{i.a(c.dzU, "PredownloadCmdGetCodePersistentInfo")};
    private final e fgu;

    public d(e eVar) {
        super(eVar, c.dzU, "PredownloadCmdGetCodePersistentInfo", c.ciG);
        this.fgu = eVar;
    }

    public final List<c> d(String str, String... strArr) {
        Cursor query = this.fgu.query("PredownloadCmdGetCodePersistentInfo", null, str, strArr, null, null, null);
        if (query == null || query.isClosed()) {
            return Collections.emptyList();
        }
        List<c> linkedList = new LinkedList();
        if (query.moveToFirst()) {
            do {
                c cVar = new c();
                cVar.d(query);
                linkedList.add(cVar);
            } while (query.moveToNext());
        }
        query.close();
        return linkedList;
    }
}

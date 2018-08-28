package com.tencent.mm.plugin.appbrand.appcache.a.d;

import com.tencent.mm.g.c.fa;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends fa {
    static final a dzU;

    protected final a AX() {
        return dzU;
    }

    static {
        a aVar = new a();
        aVar.sKy = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.sKA.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "username";
        aVar.columns[1] = "appVersion";
        aVar.sKA.put("appVersion", "INTEGER");
        stringBuilder.append(" appVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "reportId";
        aVar.sKA.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        dzU = aVar;
    }
}

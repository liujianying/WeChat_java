package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.g.c.en;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class z extends en {
    public static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "pref_key";
        aVar.sKA.put("pref_key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" pref_key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "pref_key";
        aVar.columns[1] = "pref_title";
        aVar.sKA.put("pref_title", "TEXT");
        stringBuilder.append(" pref_title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "pref_url";
        aVar.sKA.put("pref_url", "TEXT");
        stringBuilder.append(" pref_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "is_show";
        aVar.sKA.put("is_show", "INTEGER default '1' ");
        stringBuilder.append(" is_show INTEGER default '1' ");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}

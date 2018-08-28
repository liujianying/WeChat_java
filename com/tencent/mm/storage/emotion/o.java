package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.g.c.bs;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class o extends bs {
    public static a dhO;

    protected final a AX() {
        return null;
    }

    public o(String str, byte[] bArr) {
        this.field_reqType = str;
        this.field_cache = bArr;
    }

    public o(Cursor cursor) {
        if (cursor != null) {
            d(cursor);
        }
    }

    static {
        a aVar = new a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "reqType";
        aVar.sKA.put("reqType", "TEXT PRIMARY KEY ");
        stringBuilder.append(" reqType TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "reqType";
        aVar.columns[1] = "cache";
        aVar.sKA.put("cache", "BLOB default '' ");
        stringBuilder.append(" cache BLOB default '' ");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }
}

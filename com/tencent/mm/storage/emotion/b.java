package com.tencent.mm.storage.emotion;

import com.tencent.mm.g.c.at;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends at {
    protected static a dhO;

    protected final a AX() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.sKy = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "md5_lang";
        aVar.sKA.put("md5_lang", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" md5_lang TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.sKz = "md5_lang";
        aVar.columns[1] = "md5";
        aVar.sKA.put("md5", "TEXT COLLATE NOCASE ");
        stringBuilder.append(" md5 TEXT COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.columns[2] = "lang";
        aVar.sKA.put("lang", "TEXT COLLATE NOCASE ");
        stringBuilder.append(" lang TEXT COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.columns[3] = "desc";
        aVar.sKA.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "groupId";
        aVar.sKA.put("groupId", "TEXT default '' ");
        stringBuilder.append(" groupId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "click_flag";
        aVar.sKA.put("click_flag", "INTEGER");
        stringBuilder.append(" click_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "download_flag";
        aVar.sKA.put("download_flag", "INTEGER");
        stringBuilder.append(" download_flag INTEGER");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    public final String Xh() {
        return this.field_md5 == null ? "" : this.field_md5;
    }
}

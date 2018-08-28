package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.g.c.bx;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends bx {
    public static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "rankID";
        aVar.sKA.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "appusername";
        aVar.sKA.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.sKA.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "timestamp";
        aVar.sKA.put("timestamp", "INTEGER default '0' ");
        stringBuilder.append(" timestamp INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "liketips";
        aVar.sKA.put("liketips", "TEXT default '' ");
        stringBuilder.append(" liketips TEXT default '' ");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}

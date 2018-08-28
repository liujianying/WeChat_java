package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.mm.g.c.em;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class y extends em {
    public static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "mNativeUrl";
        aVar.sKA.put("mNativeUrl", "TEXT PRIMARY KEY ");
        stringBuilder.append(" mNativeUrl TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "mNativeUrl";
        aVar.columns[1] = "hbType";
        aVar.sKA.put("hbType", "INTEGER");
        stringBuilder.append(" hbType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "receiveAmount";
        aVar.sKA.put("receiveAmount", "LONG");
        stringBuilder.append(" receiveAmount LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "receiveTime";
        aVar.sKA.put("receiveTime", "LONG");
        stringBuilder.append(" receiveTime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "receiveStatus";
        aVar.sKA.put("receiveStatus", "INTEGER");
        stringBuilder.append(" receiveStatus INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "hbStatus";
        aVar.sKA.put("hbStatus", "INTEGER");
        stringBuilder.append(" hbStatus INTEGER");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final void d(Cursor cursor) {
        super.d(cursor);
    }
}

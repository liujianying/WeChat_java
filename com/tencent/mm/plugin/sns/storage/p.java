package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

public final class p extends dy {
    protected static a dhO;
    public int nJc;

    static {
        a aVar = new a();
        aVar.sKy = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "logtime";
        aVar.sKA.put("logtime", "LONG");
        stringBuilder.append(" logtime LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "offset";
        aVar.sKA.put("offset", "INTEGER default '0' ");
        stringBuilder.append(" offset INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "logsize";
        aVar.sKA.put("logsize", "INTEGER");
        stringBuilder.append(" logsize INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "errorcount";
        aVar.sKA.put("errorcount", "INTEGER");
        stringBuilder.append(" errorcount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "value";
        aVar.sKA.put("value", "BLOB");
        stringBuilder.append(" value BLOB");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final void d(Cursor cursor) {
        try {
            super.d(cursor);
            this.nJc = (int) this.sKx;
        } catch (Exception e) {
            String message = e.getMessage();
            x.e("MicroMsg.SnsKvReport", "error " + message);
            if (message != null && message.contains("Unable to convert")) {
                af.byt().bAR();
            }
            throw e;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsKvReport", e2, "", new Object[0]);
        }
    }
}

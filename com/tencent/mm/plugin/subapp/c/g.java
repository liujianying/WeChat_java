package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.g.c.eg;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends eg {
    protected static a dhO;
    int bWA = -1;

    static {
        a aVar = new a();
        aVar.sKy = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "filename";
        aVar.sKA.put("filename", "TEXT");
        stringBuilder.append(" filename TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "user";
        aVar.sKA.put("user", "TEXT");
        stringBuilder.append(" user TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "msgid";
        aVar.sKA.put("msgid", "LONG");
        stringBuilder.append(" msgid LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "offset";
        aVar.sKA.put("offset", "INTEGER");
        stringBuilder.append(" offset INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "filenowsize";
        aVar.sKA.put("filenowsize", "INTEGER");
        stringBuilder.append(" filenowsize INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "totallen";
        aVar.sKA.put("totallen", "INTEGER");
        stringBuilder.append(" totallen INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "status";
        aVar.sKA.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "createtime";
        aVar.sKA.put("createtime", "LONG");
        stringBuilder.append(" createtime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "lastmodifytime";
        aVar.sKA.put("lastmodifytime", "LONG");
        stringBuilder.append(" lastmodifytime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "clientid";
        aVar.sKA.put("clientid", "TEXT");
        stringBuilder.append(" clientid TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "voicelenght";
        aVar.sKA.put("voicelenght", "INTEGER");
        stringBuilder.append(" voicelenght INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "msglocalid";
        aVar.sKA.put("msglocalid", "INTEGER");
        stringBuilder.append(" msglocalid INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "human";
        aVar.sKA.put("human", "TEXT");
        stringBuilder.append(" human TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "voiceformat";
        aVar.sKA.put("voiceformat", "INTEGER");
        stringBuilder.append(" voiceformat INTEGER");
        stringBuilder.append(", ");
        aVar.columns[14] = "nettimes";
        aVar.sKA.put("nettimes", "INTEGER");
        stringBuilder.append(" nettimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "reserved1";
        aVar.sKA.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[16] = "reserved2";
        aVar.sKA.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        aVar.columns[17] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final boolean TM() {
        if ((this.field_status <= 1 || this.field_status > 3) && this.field_status != 8) {
            return false;
        }
        return true;
    }
}

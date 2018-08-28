package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.g.c.dr;
import com.tencent.mm.protocal.c.bmw;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class n extends dr {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_id";
        aVar.sKA.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "card_id";
        aVar.columns[1] = "state_flag";
        aVar.sKA.put("state_flag", "INTEGER");
        stringBuilder.append(" state_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "update_time";
        aVar.sKA.put("update_time", "LONG");
        stringBuilder.append(" update_time LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "seq";
        aVar.sKA.put("seq", "LONG");
        stringBuilder.append(" seq LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "retryCount";
        aVar.sKA.put("retryCount", "INTEGER");
        stringBuilder.append(" retryCount INTEGER");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        if (this.field_card_id == ((n) obj).field_card_id) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.field_card_id == null ? 0 : this.field_card_id.hashCode();
    }

    public static n b(bmw bmw) {
        n nVar = new n();
        nVar.field_card_id = bmw.cac;
        nVar.field_update_time = (long) bmw.rqg;
        nVar.field_state_flag = bmw.hyk;
        nVar.field_seq = bmw.slb;
        nVar.field_retryCount = 10;
        return nVar;
    }
}

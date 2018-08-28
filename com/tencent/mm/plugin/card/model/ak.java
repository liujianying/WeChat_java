package com.tencent.mm.plugin.card.model;

import com.tencent.mm.g.c.cx;
import com.tencent.mm.protocal.c.lh;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ak extends cx {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "cardUserId";
        aVar.sKA.put("cardUserId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" cardUserId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "cardUserId";
        aVar.columns[1] = "retryCount";
        aVar.sKA.put("retryCount", "INTEGER");
        stringBuilder.append(" retryCount INTEGER");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ak)) {
            return false;
        }
        if (this.field_cardUserId == ((ak) obj).field_cardUserId) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.field_cardUserId == null ? 0 : this.field_cardUserId.hashCode();
    }

    public static ak a(lh lhVar) {
        ak akVar = new ak();
        akVar.field_cardUserId = lhVar.ros;
        return akVar;
    }
}

package com.tencent.mm.storage;

import com.tencent.mm.g.c.eb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class bq extends eb {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "encryptUsername";
        aVar.sKA.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "encryptUsername";
        aVar.columns[1] = "conRemark";
        aVar.sKA.put("conRemark", "TEXT default '' ");
        stringBuilder.append(" conRemark TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "contactLabels";
        aVar.sKA.put("contactLabels", "TEXT default '' ");
        stringBuilder.append(" contactLabels TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "conDescription";
        aVar.sKA.put("conDescription", "TEXT default '' ");
        stringBuilder.append(" conDescription TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "conPhone";
        aVar.sKA.put("conPhone", "TEXT default '' ");
        stringBuilder.append(" conPhone TEXT default '' ");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public bq(String str) {
        this();
        this.field_conRemark = "";
        if (str == null) {
            str = "";
        }
        this.field_encryptUsername = str;
    }

    public bq(String str, String str2) {
        this();
        if (str == null) {
            str = "";
        }
        this.field_encryptUsername = str;
        if (str2 == null) {
            str2 = "";
        }
        this.field_conRemark = str2;
    }

    public bq() {
        this.field_encryptUsername = "";
        this.field_conRemark = "";
    }

    public final String wR() {
        return this.field_encryptUsername;
    }

    public final String wN() {
        return this.field_conRemark;
    }

    protected final Object clone() {
        return super.clone();
    }
}

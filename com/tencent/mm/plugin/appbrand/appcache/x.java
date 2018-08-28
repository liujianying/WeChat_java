package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.appbrand.p.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Locale;

public final class x extends dd implements b {
    static final a dzU;
    static final String[] fgs = new String[]{"appId", "type", "version"};

    public final String[] getKeys() {
        return fgs;
    }

    protected final a AX() {
        return dzU;
    }

    static {
        int i = 0;
        a aVar = new a();
        aVar.sKy = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "version";
        aVar.sKA.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "type";
        aVar.sKA.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "pkgMd5";
        aVar.sKA.put("pkgMd5", "TEXT");
        stringBuilder.append(" pkgMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "pkgPath";
        aVar.sKA.put("pkgPath", "TEXT");
        stringBuilder.append(" pkgPath TEXT");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        dzU = aVar;
        String str = " PRIMARY KEY ( ";
        String[] strArr = fgs;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = dzU;
        aVar2.sql = stringBuilder2.append(aVar2.sql).append(",").append(str2).toString();
    }

    public final String toShortString() {
        return String.format(Locale.US, "EncryptPkgInfo[%s %d %d]", new Object[]{this.field_appId, Integer.valueOf(this.field_type), Integer.valueOf(this.field_version)});
    }
}

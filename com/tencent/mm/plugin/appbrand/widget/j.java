package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.g.c.ck;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class j extends ck {
    public static final a fgt;

    static {
        a aVar = new a();
        aVar.sKy = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appIdHash";
        aVar.sKA.put("appIdHash", "INTEGER");
        stringBuilder.append(" appIdHash INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "pkgType";
        aVar.sKA.put("pkgType", "INTEGER");
        stringBuilder.append(" pkgType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "widgetType";
        aVar.sKA.put("widgetType", "INTEGER");
        stringBuilder.append(" widgetType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "launchAction";
        aVar.sKA.put("launchAction", "BLOB");
        stringBuilder.append(" launchAction BLOB");
        stringBuilder.append(", ");
        aVar.columns[5] = "jsApiInfo";
        aVar.sKA.put("jsApiInfo", "BLOB");
        stringBuilder.append(" jsApiInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[6] = "versionInfo";
        aVar.sKA.put("versionInfo", "BLOB");
        stringBuilder.append(" versionInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[7] = "widgetSetting";
        aVar.sKA.put("widgetSetting", "BLOB");
        stringBuilder.append(" widgetSetting BLOB");
        aVar.columns[8] = "rowid";
        aVar.sql = stringBuilder.toString();
        fgt = aVar;
    }

    protected final a AX() {
        return fgt;
    }
}

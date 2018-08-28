package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.g.c.er;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

final class g extends er {
    protected static a dhO;

    g() {
    }

    static {
        a aVar = new a();
        aVar.sKy = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "disable";
        aVar.sKA.put("disable", "INTEGER default 'false' ");
        stringBuilder.append(" disable INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "configId";
        aVar.sKA.put("configId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" configId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "configId";
        aVar.columns[2] = "configUrl";
        aVar.sKA.put("configUrl", "TEXT");
        stringBuilder.append(" configUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "configResources";
        aVar.sKA.put("configResources", "TEXT");
        stringBuilder.append(" configResources TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "configCrc32";
        aVar.sKA.put("configCrc32", "LONG");
        stringBuilder.append(" configCrc32 LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "isFromXml";
        aVar.sKA.put("isFromXml", "INTEGER default 'false' ");
        stringBuilder.append(" isFromXml INTEGER default 'false' ");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName() + " {");
        try {
            for (Field field : getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().startsWith("field_")) {
                    field.setAccessible(true);
                    stringBuilder.append(field.getName().replaceFirst("field_", "")).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebViewCacheResConfigMap", e, "", new Object[0]);
        }
        return stringBuilder.append(" }").toString();
    }
}

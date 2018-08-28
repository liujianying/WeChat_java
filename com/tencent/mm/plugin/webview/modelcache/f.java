package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.g.c.ev;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

public final class f extends ev {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "urlMd5Hashcode";
        aVar.sKA.put("urlMd5Hashcode", "INTEGER");
        stringBuilder.append(" urlMd5Hashcode INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "url";
        aVar.sKA.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "domain";
        aVar.sKA.put("domain", "TEXT");
        stringBuilder.append(" domain TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "version";
        aVar.sKA.put("version", "TEXT");
        stringBuilder.append(" version TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "localPath";
        aVar.sKA.put("localPath", "TEXT");
        stringBuilder.append(" localPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "contentType";
        aVar.sKA.put("contentType", "TEXT");
        stringBuilder.append(" contentType TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "contentLength";
        aVar.sKA.put("contentLength", "LONG");
        stringBuilder.append(" contentLength LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "isLatestVersion";
        aVar.sKA.put("isLatestVersion", "INTEGER");
        stringBuilder.append(" isLatestVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "createTime";
        aVar.sKA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "accessTime";
        aVar.sKA.put("accessTime", "LONG");
        stringBuilder.append(" accessTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "expireTime";
        aVar.sKA.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "cacheType";
        aVar.sKA.put("cacheType", "INTEGER");
        stringBuilder.append(" cacheType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "configId";
        aVar.sKA.put("configId", "TEXT");
        stringBuilder.append(" configId TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "protocol";
        aVar.sKA.put("protocol", "INTEGER");
        stringBuilder.append(" protocol INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "packageId";
        aVar.sKA.put("packageId", "TEXT");
        stringBuilder.append(" packageId TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "contentMd5";
        aVar.sKA.put("contentMd5", "TEXT");
        stringBuilder.append(" contentMd5 TEXT");
        aVar.columns[17] = "rowid";
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
            x.printErrStackTrace("MicroMsg.WebViewCacheRes", e, "", new Object[0]);
        }
        return stringBuilder.append(" }").toString();
    }
}
